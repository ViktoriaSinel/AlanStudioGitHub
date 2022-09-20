//Demo Script for ibs Software


corpus(
    {url: "https://www.ibsplc.com/", depth: 3},
);



const yesOrNoContext = context(() => {
    intent("(yes|sure|) (please|)", p => p.resolve("yes"));
    intent("no (thank you|thanks|need|)", p => p.resolve("no"));
    intent("i (would like|want) to (speak|talk) to (someone|a represetative)", p => p.resolve("contact"));
    intent("i (would like|want) to see the brochure", p => p.resolve("brochure"));
})


intent("Do you (have|offer) MRO solution_", p => {
    p.play("Yes, redirecting to the solution page")
    p.play({
        command: "load-page",
        url: "https://www.ibsplc.com/product/airline-operations-solutions/iflight"
    });
});

//HOMEPAGE


intent("(go|navigate) (back|) (to homepage|)", p => {
    p.play("navigating to homepage");
    p.play({
        command: "click-by-element",
        selector: ".header-with-social > div > div > div > div > div > div > a"
    })
}) 


intent('what (is|does) ibs (software|) (do|)', p => {
    p.play('IBS is an IT company that provides software solutions to the global air transportation industry.')
})


intent("(show me|I'm interested in|I'd like to learn about) (the|) airline passenger (solution_|)", p => {
    p.play({
        command: "scroll-to-element",
        selector: "#airline-products"
    });
    p.play("With native NDC and offer and order management capabilities, iFly maximizes personalized retail opportunities across channels and traveler touchpoints and end-to-end passenger processing.");
});


intent("I'm interested in air cargo solutions", p => {
    p.play({
        command: "scroll-to-element",
        selector: "#airline-products"
    })
    p.play("Co-developed with the world's leading cargo airlines and ground handlers, iCargo maximizes revenues, collaboration, and cost-efficiencies across the value chain.");
});

intent('what is hospitality sales and distribution', async p => {
        p.play({
        command: 'scroll-to-element',
        selector: "#non-airline-products"
    });
    p.play("iHospitality is an omnichannel sales and distribution platform for hotels, resorts, and casinos. It unifies B2B and B2C commercial activities and processes for the world's leading properties through a single, data-driven platform. Would you like to hear about how we transformed hospitality?")
    const yesOrNoContextAnswer = await p.then(yesOrNoContext);
    console.log(yesOrNoContextAnswer);
    
    if(yesOrNoContextAnswer.includes("yes")) {
        p.play("Alright, here's the overview")
        p.play({
            command: 'click-by-element',
            selector: "#non-airline-products > div > div > div > div > div > div > div > div > div > div > a"
    });
    } else if(yesOrNoContextAnswer.includes("no")) {
        p.play("Okay")
    }
});


intent("(I would like to hear|what are|show me|) (the|) (what's the latest|) news (on IBS Software|)", p => {
    p.play({
        command: "scroll-to-element",
        selector: "#news-insights-home"
    })
    p.play("Here are the recent news. Cebu Pacific selects IBS Software to transform crew operations. IBS Software partners with Brunei Shell Petroleum Co. to transform end-to-end people supply chain and reduce logistics emissions. IBS Software Joins Global Wind Energy Council to Accelerate Offshore Wind Supply Chain Performance");
}) 


intent("what aviation solution_ do you (offer|have)", p => {
    p.play("Here are our Aviation solutions");
    p.play({
        command: "click-by-element",
        selector: "[href*='/product/all-aviation']"
    })
}) 


intent("what airline operations solutions does IBS provide", p => {
    p.play("Redirecting to operations solutions page");
    p.play({
        command: "click-by-element",
        selector: "#sp-menu [href*='/airline-operations-solutions']"
    })
});







//airline-operations-solutions page

intent("show me the details please", p => {
   p.play("Alright, here are the details");
    p.play({
        command: "click-by-element",
        selector: "#sp-page-builder > div > section > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div [href*='/iflight']"
    })
});

intent("(what is|tell me more about) iFlight", async p => {
    p.play("iFlight is the suite of IBS' airline operations solutions, would you like to learn more?");
    const yesOrNoContextAnswer = await p.then(yesOrNoContext);
    console.log(yesOrNoContextAnswer);
    
    if (yesOrNoContextAnswer.includes("yes")) {
        p.play("Alright, here you go");
        p.play({
            command: "click-by-element",
            selector: "#sp-page-builder > div > section > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div [href*='/iflight']"
        });
    } else if (yesOrNoContextAnswer.includes("no")) {
                p.play("Okay");
    }
});


//iFlight

intent("tell me more about (MRO|maintenance and repair) (solution_|)", p => {
//     p.play("Alright, here you go");
    p.play({
        command: "scroll-to-element",
        selector: ".page-content section:nth-child(4) .sppb-panel-group > div:nth-child(1) > div:nth-child(1)"
    });
   p.play({
        command: "click-by-element",
        selector: ".page-content section:nth-child(4) .sppb-panel-group > div:nth-child(5) > div:nth-child(1)"
   });
    p.play("iFlight MRO is an airline maintenance and engineering solution to successfully manage all the technical, operational, regulatory, and commercial aspects of maintenance, engineering, and logistics requirements of the airline industry.");
});


intent("(do|does) (you|this|ibs) (offer|provide|have|include) (an|) (MRO|maintenance and repair) solution_", async p => {
    p.play("Yes");
    p.play({
        command: "scroll-to-element",
        selector: ".page-content section:nth-child(4) .sppb-panel-group > div:nth-child(1) > div:nth-child(1)"
    })
    p.play({
        command: "click-by-element",
        selector: ".page-content section:nth-child(4) .sppb-panel-group > div:nth-child(5) > div:nth-child(1)"
    })
    p.play("Would you like to download the brochure or contact us to learn more or would you like to speak to someone?")
    const yesOrNoContextAnswer = await p.then(yesOrNoContext);
    console.log(yesOrNoContextAnswer);
    
    if(yesOrNoContextAnswer.includes("brochure")) {
        p.play("Alright, make sure you have your add blocker off");
        p.play({
            command: "click-by-element",
            selector: ".page-content section:nth-child(4)  .sppb-panel-group > div:nth-child(5) a"
        })  
    } else if (yesOrNoContextAnswer.includes("contact")) {
        p.play("Great, let's gather some information and one of the IBS team will get in touch");
        p.play({
            command: "click-by-element",
            selector: "#sp-bottom > div > div > div > div [href='/contact']"
        })  
    }
});



















//Pieace of code to insert button

// import("https://studio.alan-stage.app/web/lib/inject_alan_btn.js?v=1").then(function () {
//     window.insertAlanBtn("fda1c7c0882e6ed67ac6e96607096ab42e956eca572e1d8b807a3e2338fdd0dc/testing");
// });


//Piece of code to insert button on the left side of the page

// import("https://studio.alan-stage.app/web/lib/inject_alan_btn.js?v=2").then(function () {
//     const options = {
//        bottom: '50px',
//        left: '50px',
//        zIndex: 10
//     }
//     window.insertAlanBtn("fda1c7c0882e6ed67ac6e96607096ab42e956eca572e1d8b807a3e2338fdd0dc/testing", options);
// });


//Website Link

// https://www.ibsplc.com/