(ns cljts.test.transform
  (:use midje.sweet
        cljts.transform
        [cljts.geom :only [c point]]))

(fact
 (let [rotation 
       (transformation [(c 0 0)  (c 1 0)  (c 0 1)
                         (c 0 0)  (c 0 1)  (c -1 0)])]
   (rotation (c 0 0)) => (c 0 0)
   (rotation (c 1 0)) => (c 0 1)
   (rotation (c 0 1)) => (c -1 0)))

(fact
 (let [rotation 
       (transformation [(c 0 0)  (c 1 0)  (c 0 1)
                         (c 0 0)  (c 1 1)  (c -1 1)])]
   (rotation (point (c 0 0))) => (point (c 0 0))
   (rotation (point (c 1 0))) => (point (c 1 1))
   (rotation (point (c 0 1))) => (point (c -1 1))))   

(fact
 (let [scale 
       (transformation [(c 0 0)  (c 1 0)  (c 0 1)
                         (c 0 0)  (c 2 1)  (c 0 2)])]
   (scale (c 0 0)) => (c 0 0)
   (scale (c 1 0)) => (c 2 1)
   (scale (c 0 1)) => (c 0 2)))

(fact
 (let [translate 
       (transformation [(c 0 0)  (c 1 0)  (c 0 1)
                         (c 5 6)  (c 6 6)  (c 5 7)])]
   (translate (c 0 0)) => (c 5 6)
   (translate (c 1 0)) => (c 6 6)
   (translate (c 0 1)) => (c 5 7)))

(fact
 (let [linear 
       (transformation [(c 0 0)  (c 1 0)  (c 0 1)
                         (c 0 0)  (c 0 0)  (c 5 7)])]
   (linear (c 0 0)) => (c 0 0)
   (linear (c 1 0)) => (c 0 0)
   (linear (c 0 1)) => (c 5 7)))

(fact
 (let [translaton 
       (transformation [(c 0 0)
                         (c 5 6)])]
   (translaton (c 0 0)) => (c 5 6)))

(fact
 (let [linear 
       (transformation [(c 0 0)  (c 1 1)
                         (c 5 5)  (c 6 9)])]
   (linear (c 0 0)) => (c 5 5)
   (linear (c 1 1)) => (c 6 9)))

(fact
 (let [inverse 
       (inverse-transformation [(c 0 0)  (c 1 0)  (c 0 1)
                                 (c 0 0)  (c 2 1)  (c 0 2)])]
   (inverse (c 0 0)) => (c 0 0)
   (inverse (c 2 1)) => (c 1 0)
   (inverse (c 0 2)) => (c 0 1)))

(fact
 (let [coord (c (rand) (rand))]
   (identity-transformation coord) => coord))

(fact 
    (reproject (point (c 17.992731 -76.792009)) "EPSG:4326" "EPSG:3857" )
    =>  (point (c 2002941.652900348 -13751964.581751062))
    (reproject (point (c 17.992731 -76.792009)) "EPSG:4326" "EPSG:23032" )
    =>  (point (c 728546.5603152956 -8541179.551353851))
   (reproject (point (c 10.10 20.20)) "EPSG:4326" "EPSG:32632")
    =>  (point (c 614925.1396623004 2233994.5256219646)))

(fact "Get proper UTM"
      (let [o0 (point (c -55.68333 -15.48333))
            o1 (point (c -48.2772 -18.9186))
            o2 (point (c -38.0738 -7.8783))
            o3 (point (c 20.20 10.10))
            ]
        (utmzone o0) => "EPSG:32721" 
        (utmzone o1) => "EPSG:32722" 
        (utmzone o2) => "EPSG:32724" 
        (utmzone o3) => "EPSG:32634"))

