async function postGuide({ title, description, content }){
    let response = await fetch(`/guides?title=${ title }&description=${ description }&content=${ content }` , {
        method: 'POST'
    });

    if(response.status != 201){
        throw Error('Something went wrong with the request.');
    }

    let guide = await response.json();
    console.log(guide);
}

function testPostGuides(){
    let exampleTitle = 'Example title ';
    let exampleDescription = 'Example description ';
    let exampleContent = 'Example content ';

    for(let i = 1; i < 11;i++){
        postGuide({
            title: exampleTitle + i,
            description: exampleDescription + i,
            content: exampleContent + i,
        });
    }
}