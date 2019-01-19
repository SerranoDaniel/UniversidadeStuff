(* 2018.12.04 *)

let apl1 f = function
			| x -> (f x);;

let apl2 f = function
			| x -> (f x) + (f x);;

let rec apl k f = function
			| x -> if k=1 then (f x) else apl (k-1) f x;;

(* greatest common divisor *)
let rec gcd m = function
			| 0 -> m
			| n -> gcd n (m mod n);;

let rec gcd m n = if n=0 then m else gcd n (m mod n);;
(*
*# let rec pares = function
*				| [] -> []
*				| h::t -> if h mod 2=0 then pares h::t else pares t;;
*
*
*
*# let rev list =
*	let rec aux pares = function
*					| [] -> []
*					| h::t -> if h mod 2=0 then pares h::t else pares t in aux pares list;; 
*
*)
print_string "Começou\n";;



(*if h mod 2 = 0 then pares (h::t) else pares t*)

let rec sum = function
			| [] -> 0
			| h::t -> h + sum t;;

let rec last = function
    		| [] -> 0
    		| [x] -> x
    		| _ :: t -> last t;;

let length list =
	let rec aux n = function
				| [] -> n
				| _::t -> aux (n+1) t
			in aux 0 list;;

let rec len = function
			| [] -> 0
			| _::t -> 1 + len t;;


let rec pares = function
		| [] -> []
		| h::t -> if (h mod 2) = 0 then h::pares t else pares t ;;

pares [1;2;3;4;5;6;7;8];;


let rec filter f = function
		| [] -> []
		| h::t -> if (f h) then h::(filter f t) else filter f t;; 

let rec map f = function
		| [] -> []
		| h::t -> (f h)::map f t;;

let rec append (l1:a' list) (l2:a' list) : int list = function
		| [],[] -> []
		| h::t, h1::t1-> h::(append t (h1::t1));;


let rec append l1 l2 = match l1 with
						| [] -> l2
						| h::t -> h::(append t l2);;
(* exercicio do prof)
let rec membro = function
				| x -> function
				| [] -> false
				| h::t -> if x=h then true else membro x t;;
*)
let rec membro x = function
				| [] -> false
				| h::t -> if x=h then true else membro x t;;

let rec membro l x = match x with
				| [] -> false
				| h::t -> if x=h then true else membro t x;;


let rec remove l = 
	let rec aux acc = function
					| [] -> acc
					| h::t when l=[] -> acc
					| h::t -> 
(*
let rec remove l1 l2 = match l1, l2 with
				| [],[] -> [] 
				| [], _
				| _, [] -> []
				| h::t, h1::t1 -> if h=h1 then remove t t1 else h::(remove t (h1::t1));;
*)
let rec map f = function
				| [] -> []
				| h::t -> (f h)::map f t;; 



type 'a abp =
		| Leaf
		| Node of 'a abp * 'a * 'a abp;;

let rec lookup = function
		| Leaf -> assert false
		| Node (_, x, Leaf) -> x
		| Node (_, x, r) -> lookup r;;

let rec insert x = function
		| Leaf -> Node (Leaf, x, Leaf)
		| Node (l, y, r) ->
			if x=y then Node (l, y, r)
			else if x<y then Node (insert x l, y, r)
			else Node (l, y, insert x r);;

let rec delete x = function
			| Leaf -> Leaf
			| Node (l, y, r) ->
				if x = y then join l r
				else if x < y then Node (delete x l, y, r)
				else Node (l, y, delete x r)
and join l r =	match l, r with
			| Leaf, r -> r
			| l, Leaf -> l
			| l, r -> let m = find_max l in Node (delete m l, m, r);;




print_string "Acabou\n";;