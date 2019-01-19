(* fib*)
let rec fib x = if x<=1 then 1 else fib (x-1) + fib(x-2);;

(* fact*)

let rec fact x = if x<=1 then 1 else x * fact(x-1);;

let rec ordena = function
			| [] -> []
			| h::h2::t -> if h<h2 then 

(* sort e insert*)
let rec insert elem = function
				| [] -> [elem]
				| h::t -> if elem < h then elem::h::t else h::insert elem t;;

let rec sort = function
			| [] -> []
			| h::t -> insert h (sort t);;
sort [4;2;3;5];;

(* reverse list *)

let rev list =
	let rec aux acc = function
					| [] -> acc
					| h::t -> aux (h::acc) t in aux [] list;;


(*99 problems*)
let rec last = function
			| [] -> 0
			| [x] -> x
			| _::t -> last t;;


let rec last_two = function
			| [] -> []
			| [x;y] -> [x;y]
			| _::t -> last_two t;;

let rec at k = function
			| [] -> None
			| h::t -> if k=1 then Some h else at (k-1) t;;

let length list = 
	let rec aux n = function
				| [] -> n
				| _::t -> aux (n+1) t in aux 0 list;;

(* last elemento -- recebe e devolve uma lista -- val last : 'a list -> 'a list = <fun>*)
let rec last = function
			| [] -> []
			| [x] -> [x]
			| _::t -> last t;;

(* last elemento -- recebe uma lista de ints e devolte um int -- val last : int list -> int = <fun>*)
let rec last = function
			| [] -> 0
			| [x] -> x
			| _::t -> last t;;

let rec last = function
			| [] -> None
			| [x] -> Some x
			| _::t -> last t;;

(* para k=1 *)
let rec at k = function
			| [] -> None
			| h::t -> if k=1 then Some h else at (k-1) t;;

(* para k=0 *)
let rec at k = function
			| [] -> None
			| h::t -> if k=0 then Some h else at (k-1) t;;

let len list =
	let rec aux n = function
				| [] -> 0
				| _::t -> aux (n+1) t in aux 0 list;;

let rec len x = match x with
			| [] -> 0
			| h::t -> 1 + len t;;


let rec pares = function
			| [] -> []
			| h::t -> if h mod 2 = 0 then h::(pares t) else pares t;;

let rec impares = function
			| [] -> []
			| h::t -> if h mod 2 = 1 then h::(impares t) else impares t;;

(*val append : 'a list -> 'a list -> 'a list = <fun>*)
let rec append l1 l2 = match l1 with
			| [] -> l2
			|  h::t -> h::(append t l2);;

let rec merge l1 l2 = match l1 with
			| [] -> l2
			| h::t -> h::(merge l2 t);;

(* soma com match .. with*)
let rec soma l = match l with
			| [] -> 0
			| h::t -> h + soma t;;

(* list is empty? bool*)
let empty l = match l with
			| [] -> true
			| h::t -> false;;

let empty = function
			| [] -> true
			| h::t -> false;;



let rec membro = function 
	[] -> (function a -> false)
	| x::l -> (function a -> 
		if x = a then true
		else membro l a);;

let rec remove l1 l2 = match l1,l2 with
					| [],l2 -> l2
					| l1, [] -> []
					| h::t, h1::t1 -> if h=h1 then remove (h::t) t1 else remove (h::t) t1;;

(* remover um elemento duma lista de elementos*)
let rec remove x l = match l with
				| [] -> []
				| [x] -> []
				| h::t -> let t' = remove x t in if h=x then t' else h::t';;

let rec remove x l = match l with
				| [] -> []
				| h::t -> let t' = remove x t in if h=x then t' else h::t';;

(* ordena *)

let rec ordena = function
			| [] -> []
			| h::h2::t -> if h<h2 then ordena t else ordena (h2::h::t);; 