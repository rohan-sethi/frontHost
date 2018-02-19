var i=0;

function timedCount() {
    i=i+1;
    postMessage(i);
    if(i<160)
    setTimeout("timedCount()", 100);
}

timedCount();