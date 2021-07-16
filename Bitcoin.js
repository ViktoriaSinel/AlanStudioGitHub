// {Name: Bitcoin}
// {Description: Gives Bitcoin price information, including visual charts of Bitcoin prices over the past week, month, and year.}

title('Bitcoin');

const DATE_FORMAT = 'YYYY-MM-DD';


intent(
    'how much is Bitcoin',
    '(what is|tell me|find|do you know|) (the|) (price of Bitcoin|Bitcoin price) (in|) $(CURRENCY dollar|dollars|pound|pounds|euro|euros|ruble|rubles|)',
    'how much is Bitcoin in $(CURRENCY dollar|dollars|pound|pounds|euro|euros|ruble|rubles)',
    'how many $(CURRENCY dollar|dollars|pound|pounds|euro|euros|ruble|rubles) (do I need|does it cost|are needed) to buy Bitcoin',
    async p => {
        const currencyCode = p.CURRENCY && p.CURRENCY.value ? getCurrencyCode(p.CURRENCY.value) : 'USD';

        const url = `https://api.coindesk.com/v1/bpi/currentprice/${currencyCode}.json`;
        const data = await getData(url);

        if (!data) {
            return sendErrorMessage(p);
        }

        const price = Math.trunc(data.bpi[currencyCode].rate_float);
        const currencyName = getCurrencyString(currencyCode);

        p.play(`The (current|) (Bitcoin price|price of Bitcoin) is ${price} ${currencyName}`);
    }
);

function getCurrencyString(currencyCode) {
    const values = {
        EUR: 'euros',
        RUB: 'rubles',
        GBP: 'pounds',
        USD: 'dollars',
    };
    return values[currencyCode];
}

function getCurrencyCode(currencyString) {
    const values = {
        euro: 'EUR',
        euros: 'EUR',
        pound: 'GBP',
        pounds: 'GBP',
        ruble: 'RUB',
        rubles: 'RUB',
        dollar: 'USD',
        dollars: 'USD',
    };
    return values[currencyString.toLowerCase()];
}

function getStartDate(period, timeZone) {
    return api.moment().tz(timeZone).subtract(1,   `${period}s`).format(DATE_FORMAT);
}

function sendErrorMessage(p) {
    p.play(
        `(Something went wrong.|) I (wasn't able to|couldn't) get the Bitcoin prices. (Please try again|Please try again later|)`,
        `I'm unable to get Bitcoin prices now. (Please try again|Please try again later|)`,
    );
}

async function getData(url) {
    const response = await api.axios.get(url);
    return response.data;
}
