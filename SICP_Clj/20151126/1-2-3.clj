(ns test)
(remove-ns 'test)
(ns test)

;------------------------------------------------
; 연습문제 1.14
;------------------------------------------------

;------------------------------------------------
; 연습문제 1.15
;------------------------------------------------

(defn abs [x] (Math/abs x))

(defn cube [x] (* x x x))

(defn p [x] (- (* 3 x) (* 4 (cube x))))

(defn sine [angle]
  (if (not (> (abs angle) 0.1))
    angle
    (p (sine (/ angle 3.0)))))

; a.
; 12.15(1번) -> 4.05(2번) -> 1.35(3번) -> 0.45(4번) -> 0.15(5번)

; b.
; ???
