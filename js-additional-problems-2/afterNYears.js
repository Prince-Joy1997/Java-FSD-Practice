const afterNYears = (arr,n)=>{
    
    for(i=0;i<arr.length;i++){
        
        arr[i].age += n; 
    }
    return arr;
}


console.log(afterNYears([{
    name:"Joel",
    age : 32},
    {
    name:"Fred",
    age : 44},
    {
    name:"Reginald",
    age : 65},
    {
    name:"Susan",
    age : 33},
    {
    name:"Julian",
    age : 13
    }], 1))

console.log(afterNYears([{
        name:"Baby",
        age : 2},
        {
        name:"Child",
        age : 8},
        {
        name:"Teenager",
        age : 15},
        {
        name:"Adult",
        age : 25},
        {
        name:"Elderly",
        age : 71
        }], 19))

console.log(afterNYears([{
    name: "Genie",
    age : 1000},
    {
    name:"Joe",
    age : 40
    }], 5))