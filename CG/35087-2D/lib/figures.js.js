//Funcao para a parte esquerda do emblema
function leftface(c2d){
    c2d.beginPath();
        c2d.moveTo(0.27916666666666656,-0.8224852071005917);
        c2d.bezierCurveTo(-0.5625,-0.7041420118343196,-0.3125,-0.4674556213017751,0.8,-0.08284023668639051);
        c2d.bezierCurveTo(1,0.2426035502958579,0.5208333333333333,0.7159763313609468,0.28333333333333344,1);
        c2d.lineTo(-0.1875,0.834319526627219);
        c2d.lineTo(-0.0625,0.7662721893491125);
        c2d.bezierCurveTo(-0.0625,0.30177514792899407,-0.5833333333333333,0.09467455621301779,-0.5,0.12130177514792906);
        c2d.lineTo(-0.258333333333333,-0.011834319526627168);
        c2d.bezierCurveTo(-1,-0.5266272189349113,-0.7916666666666666,-1,0.27916666666666656,-0.8224852071005917);
    c2d.closePath();
}

//Funcao para a parte direita do emblema
function rightface(c2d){
    c2d.beginPath();
        c2d.moveTo(0.1941860465116278,-1);
        c2d.bezierCurveTo(0.5813953488372092,-0.7755905511811023,0.34883720930232553,-0.40157480314960625,-0.1697674418604651,-0.4133858267716536);
        c2d.bezierCurveTo(-0.10953488372093026,-0.027559055118110187,-0.4348837209302326,0.5236220472440944,-0.88,0.98);
        c2d.lineTo(-0.5253488372093023,0.8546456692913387);
        c2d.bezierCurveTo(-0.5511627906976745,0.6614173228346456,-0.023255813953488413,0.3464566929133859,0.05581395348837215,0.011811023622047223);
        c2d.bezierCurveTo(0.7674418604651163,-0.14566929133858264,1,-0.7362204724409449,0.1941860465116278,-1);
    c2d.closePath();
}

//Funcao para a parte externa do emblema (Parte brance)
function extface(c2d){
    c2d.beginPath();
        c2d.moveTo(-0.08536585365853655,-0.6982643524699599);
        c2d.bezierCurveTo(-0.8292682926829268,-1,-1,-0.46595460614152207,-0.6024390243902439,0.022696929238985364);
        c2d.lineTo(-0.7439024390243902,0.14819759679572764);
        c2d.bezierCurveTo(-0.7073170731707317,0.14819759679572764,-0.41463414634146345,0.30841121495327095,-0.41951219512195126,0.6929238985313753);
        c2d.lineTo(-0.5390243902439025,0.7970627503337784);
        c2d.lineTo(-0.17317073170731712,1);
        c2d.lineTo(0.12195121951219523,0.8424566088117491);
        c2d.bezierCurveTo(0.08536585365853666,0.7356475300400533,0.4878048780487805,0.4419225634178905,0.4536585365853658,0.29238985313751664);
        c2d.bezierCurveTo(0.8780487804878048,0.17489986648865163,1,-0.3591455273698264,0.3804878048780487,-0.4819759679572764);
        c2d.bezierCurveTo(0.6707317073170731,-0.27903871829105475,0.5,-0.060080106809078826,0.18780487804878043,-0.07076101468624829);
        c2d.bezierCurveTo(-0.04878048780487809,-0.22563417890520698,-0.8414634146341463,-0.5460614152202937,-0.08536585365853655,-0.6982643524699599);  
    c2d.closePath();
}

//Funcao para a estrela
function star(c2d){
    c2d.beginPath();
        c2d.moveTo(0.061224489795918435,-1);
        c2d.lineTo(0.22448979591836737,-0.22666666666666668);
        c2d.lineTo(1,0.14666666666666672);
        c2d.lineTo(0.33333333333333326,0.24);
        c2d.lineTo(0.4965986394557824,1);
        c2d.lineTo(-0.07482993197278909,0.32000000000000006);
        c2d.lineTo(-0.7414965986394557,0.41333333333333333);
        c2d.lineTo(-0.44217687074829937,-0.12);
        c2d.lineTo(-1,-0.8266666666666667);
        c2d.lineTo(-0.2517006802721088,-0.4666666666666667);
        c2d.lineTo(0.061224489795918435,-1);
    c2d.closePath();
}

//Funcoes essenciais para diminuir o codigo
function draw(c2d, dx, dy, sx, sy, r) {
    c2d.save();
    c2d.translate(dx,dy);
    c2d.scale(sx,sy);
    c2d.rotate(r);
}


function leave(c2d, fs, ss) {
    c2d.restore();
    c2d.fillStyle = fs;
    c2d.strokeStyle = ss;
    c2d.fill();
    c2d.stroke();
}
//
//
//Animação
scene = function(c2d, poslf, sizelf, posrf, sizerf, rotrf, posef, sizeef, rotef, posst, sizest, rotst, colorst) {

    this.c2d = c2d;
    this.poslf = poslf;
    this.sizelf = sizelf;
    this.posrf = posrf;
    this.sizerf = sizerf;
    this.rotrf = rotrf;
    this.posef = posef;
    this.sizeef = sizeef;
    this.rotef = rotef;
    this.posst = posst;
    this.sizest = sizest;
    this.rotst = rotst;
    this.colorst = colorst;


    this.animate = function() {

        c2d.fillStyle = "black";
        c2d.fillRect(0,0,670,670); 
//
//
//desenho da funcao extface()
        draw(c2d, posef.x, posef.y, sizeef.width, sizeef.height, rotef.alpha);
            extface(c2d);
        leave(c2d, "#FFFFFF", 'rgba(0,0,0,0)');
//
//
//desenho da funcao leftface()
        draw(c2d, poslf.x, poslf.y, sizelf.width, sizelf.height);

            leftface(c2d); 

        leave(c2d, "#03202f", 'rgba(0,0,0,0)');
//
//
//desenho da funcao rightface()
        draw(c2d, posrf.x, posrf.y, sizerf.width, sizerf.height, rotrf.alpha);

            rightface(c2d); 

        leave(c2d, "#a71930", 'rgba(0,0,0,0)');
//
//
//desenho da funcao star()
        draw(c2d, posst.x, posst.y, sizest.width, sizest.height, rotst.alpha);

            star(c2d); 

        leave(c2d, "rgb("+colorst.r+"," + colorst.g + "," + colorst.b + ")", 'rgba(0,0,0,0)');
//
//

        TWEEN.update();        

        requestAnimationFrame(animate);
    }

    return this;
}
//
//
////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
function main() {
    var cv = document.getElementById("mycanvas");
    var c = cv.getContext("2d");
//
//
//Animacao da funcao leftface()
    //Posicao
    var poslf = {x: -170, y: -150};
    var poslf_target= {x: 200, y: 305};
    var poslf_tween = new TWEEN.Tween(poslf).to(poslf_target, 1000);
    poslf_tween.easing(TWEEN.Easing.Quadratic.Out);
    poslf_tween.start(2300);
    //Escala
    var sizelf = {width: 230, height: 315};
    var sizelf_target = {width: 250, height: 335};
    var sizelf_tween = new TWEEN.Tween(sizelf).to(sizelf_target, 1000).repeat(8).yoyo(true);
    sizelf_tween.start(2300);

//
//
//Animacao da funcao rightface()
    //Posicao
    var posrf = {x: 750, y: 750};
    var posrf_target= {x: 490, y: 385};
    var posrf_tween = new TWEEN.Tween(posrf).to(posrf_target, 1000);
    posrf_tween.easing(TWEEN.Easing.Quadratic.Out);
    posrf_tween.start(2300);
    //Escala
    var sizerf = {width: 230, height: 230};
    var sizerf_target = {width: 250, height: 250};
    var sizerf_tween = new TWEEN.Tween(sizerf).to(sizerf_target, 1000).repeat(8).yoyo(true);
    sizerf_tween.start(2300);
    //Rotacao
    var rotrf = {alpha: 0};
    var rotrf_target = {alpha: -0.05}; 
    var rotrf_tween = new TWEEN.Tween(rotrf).to(rotrf_target, 0000)
    rotrf_tween.start();
//
//
//Animacao da funcao extface()
    //Posicao
    var posef = {x: 335, y: 335};
    var posef_target= {x: 335, y: 295};
    var posef_tween = new TWEEN.Tween(posef).to(posef_target, 2000);
    posef_tween.easing(TWEEN.Easing.Quadratic.Out);
    posef_tween.start();
    //Escala
    var sizeef = {width: 1000, height: 1000};
    var sizeef_target = {width: 415, height: 375};
    var sizeef_tween = new TWEEN.Tween(sizeef).to(sizeef_target, 500)
        .repeat(2)
        .yoyo(true);
    sizeef_tween.easing(TWEEN.Easing.Quadratic.InOut);
    sizeef_tween.start();
    //Rotacao
    var rotef = {alpha: 0};
    var rotef_target = {alpha: 2*Math.PI}; 
    var rotef_tween = new TWEEN.Tween(rotef)
        .to(rotef_target, 1000);
    rotef_tween.start(1500);
//
//
//Animacao da funcao star()
    //Rotacao
    var posst = {x: 335, y: 335};
    var posst_target= {x: 290, y: 400};
    var posst_tween = new TWEEN.Tween(posst).to(posst_target, 1000);
    posst_tween.easing(TWEEN.Easing.Quadratic.Out);
    posst_tween.start();
    //Escala
    var sizest = {width: 0, height: 0};
    var sizest_target = {width: 85, height: 85};
    var sizest_tween = new TWEEN.Tween(sizest).to(sizest_target, 1000).repeat(6).yoyo(true);
    sizest_tween.easing(TWEEN.Easing.Quadratic.InOut);
    sizest_tween.start(2300);
    //Rotacao
    var rotst = {alpha: 0};
    var rotst_target = {alpha: -20*Math.PI}; 
    var rotst_tween = new TWEEN.Tween(rotst)
        .to(rotst_target, 7000);
    rotst_tween.start();
    //Cor
    var colorst = {r: 139, g: 0, b: 0};
    var colorst_target = {r: 255, g: 255, b:255};
    var colorst_tween = new TWEEN.Tween(colorst).to(colorst_target, 2000).repeat(8).yoyo(true);
    colorst_tween.easing(TWEEN.Easing.Quadratic.InOut);
    colorst_tween.start();
//
//

    var s = scene(c, poslf, sizelf, posrf, sizerf, rotrf, posef, sizeef, rotef, posst, sizest, rotst, colorst);

    s.animate();
}