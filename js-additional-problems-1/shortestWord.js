const shortestWord = (arr) =>{

    let checklength = arr[0].length;
    let word='';
    
    for(i=0;i<arr.length;i++){
        if(checklength > arr[i].length){
            checklength = arr[i].length;
             word = arr[i]; 
        }
    }

    return console.log(word);
}



shortestWord(['hello', 'world', 'this', 'is', 'a', 'test']) // 'a'
shortestWord(['hello', 'world', 'this', 'is', 'test', 'of', 'the', 'shortest', 'word']) // 'of'