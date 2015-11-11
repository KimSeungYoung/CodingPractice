(ns test)
(remove-ns 'test)
(ns test)

; -----------------------------------------------
; 1.2 프로시저와 프로세스
; -----------------------------------------------

;------------------------------------------------
; 1.2.1 되돌거나recursion 반복하는iteration 프로세스
;------------------------------------------------

;----------------------------
; (linear) recursive process
;----------------------------
(defn factorial [n]
  (if (= n 1)
    1
    (* n (factorial (- n 1)))))

(factorial 6)
; => 720

;--------------------------------
; (linear) iterative process - 1
;--------------------------------
(defn factorial [n]
  (fact-iter 1 1 n))

(defn fact-iter [product counter max-count]
  (if (> counter max-count)
    product
    (fact-iter (* product counter) (+ counter 1) max-count)))

(factorial 6)
; => 720

;--------------------------------
; (linear) iterative process - 2
;--------------------------------
(defn factorial-iter [n]
  (defn iter [product counter]
    (if (> counter n)
      product
      (iter (* counter product)
            (+ counter 1))))
  (iter 1 1))

(factorial-iter 6)
; => 720


;------------------------------------------------
;--------------- 스터디 모임 후 --------------------
;------------------------------------------------


;------------------------------------------------
; 연습문제 1.9
;------------------------------------------------

(defn + [a b]
  (if (= a 0)
    b
    (inc (+ (dec a) b))))
; => 선형 재귀 프로세스 (Linear Recursive Process)

(defn + [a b]
  (if (= a 0)
    b
    (+ (dec a) (inc b)))
; => 선형 반복 프로세스 (Linear Iterative Process)

;------------------------------------------------
; 연습문제 1.10
;------------------------------------------------

(defn A [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (A (- x 1)
                 (A x (- y 1)))))

; Ashal's Solution
(A 1 10)
(A 0
   (A 1 9))
(A 0
   (A 0
      (A 1 8)))
(A 0 ; depth 1
   (A 0 ; depth 2
      (A 0 ; depth 3
         (A 0 ; depth 4
            (A 0 ; depth 5
               (A 0 ; depth 6
                  (A 0 ; depth 7
                     (A 0 ; depth 8
                        (A 0 ; depth 9
                           (A 1 1))))))))))
; = 2^10

(A 1 1) ; = 2^1
(A 1 2) ; = 2^2
(A 1 3) ; = 2^3
(A 1 4) ; = 2^4

(A 2 4)
(A 1
   (A 2 3))
(A 1
   (A 1
      (A 2 2)))
(A 1
   (A 1
      (A 1
         (A 2 1))))
(A 1
   (A 1
      (A 1 2)))
(A 1
   (A 1 4))
(A 1 16)
; = 2^(2^4)

(A 2 1) ; = 2
(A 2 2) ; = 2^2 = 4
(A 2 3) ; = 2^4 = 16
(A 2 4) ; = 2^16

(A 3 3)
(A 2
   (A 3 2))
(A 2
   (A 2
      (A 3 1)))
(A 2
   (A 2 2))

(A 1 10)

(A 2 4)

(A 3 3)


(defn f [n]
  (A 0 n))
;=> f(n) = 2*n

(f 100000)

(defn g [n]
  (A 1 n))
; => g(n) = 2^n

(g 16)

(defn h [n]
  (A 2 n))
; => h(n) = 2^h(n-1)

(h 4)

(defn k [n]
  (* 5 n n))
; => 5*n^2

(k 100)





