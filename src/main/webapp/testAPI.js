async function postGuide({ title, description, content, category }){
    let response = await fetch(`/guides?title=${ title }&description=${ description }&content=${ content }&category=${ category }` , {
        method: 'POST'
    });

    if(response.status != 201){
        throw Error('Something went wrong with the request.');
    }

    let guides = await response.json();
    console.log(guides);
}

function testPostGuides(){
    const categories = ['iOS', 'Android', 'Frontend', 'Backend'];

    for(let i = 1; i < 11;i++){
        postGuide({
            title: `Lorem ipsum dolor sit amet ${ i }`,
            description: `Lorem ipsum dolor sit amet, 
            consectetur adipiscing elit. Morbi feugiat erat in mauris fringilla,
            at lobortis nulla tempus. Fusce vestibulum ut lacus ullamcorper tincidunt.
            Nunc facilisis nulla vitae eros condimentum. ${ i }`,
            content: `Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce dui arcu,
            facilisis in purus non, mollis vestibulum quam. Curabitur vitae risus augue. Cras
            eget nulla malesuada, luctus ligula sed, gravida quam. Vestibulum ante ipsum primis
            in faucibus orci luctus et ultrices posuere cubilia curae; Vestibulum a auctor risus.
            Aenean iaculis auctor ligula, id pulvinar enim dictum sed. Nunc consectetur risus ac
            malesuada luctus. Phasellus nibh ligula, tincidunt id cursus ut, fringilla sit amet mauris. 
            Duis blandit dapibus mollis. Morbi accumsan lectus laoreet, iaculis lectus sit amet,
            lobortis massa. Morbi sed mollis nibh. Integer metus nulla, ultrices at ultrices vel, 
            ullamcorper sed lorem.
            \n
            Fusce velit nisl, interdum et orci et, viverra viverra dui. Aliquam vel porta sem. Sed
            facilisis ultricies lobortis. Nunc ex orci, pretium nec dapibus et, egestas a eros. 
            Maecenas suscipit aliquet commodo. Duis scelerisque leo ante, sit amet egestas turpis
            euismod eu. Pellentesque rutrum, nisi nec finibus dictum, tortor lorem malesuada augue, 
            in scelerisque sapien sem eu turpis. Suspendisse ac lorem eget libero aliquam scelerisque. 
            Cras faucibus nisi gravida mauris facilisis scelerisque. Nunc arcu nibh, efficitur in 
            ultricies a, dignissim vitae tortor. Etiam venenatis mauris eu pulvinar vulputate. Proin 
            scelerisque rutrum pretium. Orci varius natoque penatibus et magnis dis parturient montes, 
            nascetur ridiculus mus. Ut scelerisque in velit blandit finibus. Curabitur id viverra velit. 
            Vestibulum porta elit eros, id vestibulum enim suscipit ac.
            \n
            Nam quis libero a enim commodo posuere vitae eget nulla. Aenean tellus massa, interdum et 
            sollicitudin at, hendrerit in nibh. Phasellus aliquam, nisl nec cursus tincidunt, purus 
            nulla aliquet ex, ut lobortis orci ligula ut nunc. Duis orci orci, ultrices at laoreet in, 
            venenatis ut leo. Vestibulum et odio nisl. Ut vulputate bibendum est a consequat. In 
            sollicitudin diam nec massa fermentum tristique. Phasellus sollicitudin orci lorem, vitae 
            condimentum erat rutrum et. Sed facilisis, quam vitae tincidunt dapibus, tellus diam semper 
            eros, at porttitor ex nisl sit amet massa. Mauris suscipit id nisl ac porta.
            \n
            Curabitur magna lorem, rutrum ac felis mattis, lobortis maximus mauris. In pretium nisl 
            arcu, eget tempor felis vulputate nec. Mauris sit amet placerat sapien. Ut ultricies lorem quam, 
            id semper nisl auctor non. Sed volutpat rutrum viverra. Pellentesque ut dapibus libero. Donec 
            sit amet augue in nibh eleifend rhoncus sit amet eget enim. Cras facilisis lectus at elit 
            viverra ornare. Mauris vitae diam lobortis, vulputate mi eu, pharetra magna. In condimentum 
            faucibus quam id bibendum.
            \n
            Nam et vestibulum lorem. Quisque vehicula ex convallis nibh laoreet consequat in a urna. 
            Curabitur fermentum ultricies vestibulum. In hac habitasse platea dictumst. Mauris vestibulum 
            porttitor justo, sed blandit tortor cursus id. Interdum et malesuada fames ac ante ipsum 
            primis in faucibus. Curabitur lobortis augue vel mauris imperdiet, vel semper nibh dignissim. 
            Quisque pharetra leo a ante volutpat, eget feugiat mauris semper. Vivamus id bibendum nunc. 
            Proin posuere sem et lorem eleifend, non consectetur sem suscipit. Nam venenatis leo diam, 
            quis ornare dolor euismod a. Nam sem enim, dignissim sed ullamcorper et, elementum semper 
            nisl. Proin lobortis tortor tellus, vitae placerat nulla cursus non.`,
            category: categories[i % categories.length],
        });
    }
}