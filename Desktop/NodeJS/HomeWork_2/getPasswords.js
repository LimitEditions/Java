function getPassword (){
    let password = '';
    const example = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890/.,?;:!'
    for (let i = 0; i <= 8; i++) {
        password += example.charAt(Math.random()*example.length);
    }
    return password;
} 

module.exports = { getPassword};