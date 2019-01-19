let rec soma = function 
    [] -> 0 
    | x::l -> x + soma l;;

(* exerccio 1.1 *)
let rec paresList = function 
    [] -> [] 
    | x::l -> if x mod 2 = 0 
                then x::(paresList l) 
                else paresList l;;

(* exerccio 1.2 *)
let rec filtList filt  = function
    [] -> [] 
    | x::l -> if filt x 
                then x::(filtList filt l) 
                else filtList filt l;;

(*exerccio 2 *)
let rec append = function 
    | [] -> (function x -> x)
    | x::xs -> (function 
                        | l -> x::append xs l);;

    let rec append l1 l2 = match l1 with
    | [] -> l2
    |  h::t -> h::(append t l2);;


let rec coco x b = 
    for a = 0 to b do print_int get_nth x; print_string "\n"; done;;   

let rec get_nth = function
    | [], _ -> raise (Failure "get_nth")
    | _, n when n < 0 -> raise (Invalid_argument "get_nth")
    | x::_, 0 -> x
    | x::xs, n -> get_nth(xs, n-1);;