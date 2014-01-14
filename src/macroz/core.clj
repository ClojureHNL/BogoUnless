(ns macroz.core)

;; Write a macro id which takes a function and a list of args: (id f a
;; b c), and returns an expression which calls that function with the
;; given args: (f a b c).
(defmacro id [f & args]
  `(~f ~@args))

;; (unless true-or-false
;;   (do this if false))
(def x 5)
(defmacro unless [pred x]
  `(if-not ~pred ~x))

(defn plus [x y]
  (+ x y))

(defmacro unless2 [pred x]
  `(if ~pred nil ~x))

(defmacro bogounless [pred x]
  `(loop [cnt# 1]
     (println "count: " cnt# )
     (let [rand-bool# (< 0 (rand-int 2))
           _# (println "rand-bool: " rand-bool#)]
       (if (= cnt# 5)
         nil
         (if (= rand-bool# ~pred)
           (recur (inc cnt#))
           ~x)))))
