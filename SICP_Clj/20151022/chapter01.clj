; -------------------------------------
; 1.1.1 식
; -------------------------------------

; namespace
(ns test)
(remove-ns 'test)
(ns test)

(+ 486 10)

(- 1000 334)

(* 5 99)

(/ 10 5 )

(+ 2.7 10)

(+ 21 35 12 7)

(* 25 4 12)

(+ (* 3 5) (- 10 6))

(+ (* 3 (+ (* 2 4) (+ 3 5))) (+ (- 10 7) 6))

(+ (* 3
      (+ (* 2 4)
         (+ 3 5)))
   (+ (- 10 7)
      6))


; -------------------------------------
; 1.1.2 이름과 환경
; -------------------------------------

(def size 2)

(def size 3)

(* size 3)

(* 5 size)

(def pi 3.14159)

(def radius 10)

(* pi (* radius radius))

(def circumference (* 2 pi radius))

circumference

(* 3.14 0.1 0.1)

(* 3.14M 0.1M 0.1M)


; ----------- 스터디 모임 후 -------------


; -------------------------------------
; 1.1.3 엮은식 combination 을 계산하는 방법
; -------------------------------------

(* (+ 2 (* 4 6))
   (+ 3 5 7))


; -------------------------------------
; 1.1.4 묶음 프로시저 compound procedure
; -------------------------------------

(defn square [x] (* x x))

(square 21)

(square (+ 2 5))

(square (square 3))

(+ (square x) (square y))
(defn sum-of-squares [x y]
  (+ (square x) (square y)))

(sum-of-squares 3 4)

(defn f [a]
  (sum-of-squares (+ a 1) (* a 2)))

(f 5)


; -------------------------------------
; 1.1.5 맞바꿈 계산법 substitution model 으로 프로시저를 실행하는 방법
; -------------------------------------

; -------------------------------------
; 1.1.6 조건 식과 술어 predicate
; -------------------------------------

(defn abs [x]
  (cond (< x 0) (- x)
        :else x))

(abs -2)
(abs 2)

(defn abs2 [x]
  (if (< x 0)
    (- x)
    x))

(abs2 3)
(abs2 -3)


; -------------------------------------
; 연습문제 1.1
; -------------------------------------

10

(+ 5 3 4)

(- 9 1)

(/ 6 2)

(+ (* 2 4) (- 4 6))

(def a 3)

(def b (+ a 1))

(+ a b (* a b))

(= a b)

(if (and (> b a) (< b (* a b)))
  b
  a)

(cond (= a 4) (6)
      (= b 4) (+ 6 7 a)
      :else 25)

(+ 2 (if (> b a) b a))

(* (cond (> a b) a
         (< a b) b
         :else -1)
   (+ a 1))


; -------------------------------------
; 연습문제 1.2
; -------------------------------------

(/ (+ 5 4 (- 2
             (- 3
                (+ 6
                   (/ 4 5)))))
   (* 3 (- 6 2) (- 2 7)))


; -------------------------------------
; 연습문제 1.3
; -------------------------------------

(defn square [x] (* x x))

(defn sum-of-squares [x y]
  (+ (square x)
     (square y)))

(defn ex3rslt [a b c]
  (cond (>= a b c) (sum-of-squares a b)
        (>= b c a) (sum-of-squares b c)
        (>= c a b) (sum-of-squares c a)
        (>= a c b) (sum-of-squares a c)
        (>= b a c) (sum-of-squares b a)
        (>= c b a) (sum-of-squares c b)
        ))

(ex3rslt 2 4 6)


; -------------------------------------
; 연습문제 1.4
; -------------------------------------

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(a-plus-abs-b -5 3)


; -------------------------------------
; 연습문제 1.5
; -------------------------------------

(defn p [] (p))

(defn test [x y]
  (if (= x 0)
    0
    y))

(test 0 (p))
; (test 0 (p))
; => 인자 먼저 계산을 하기 때문에 무한루프에 빠짐.
