function first(callback){
    setTimeout( function(){
        console.log('First function executed');
        callback();
    },0)
}

function second(){
    console.log('Second function executed');
}
first(second);

