(defproject cljts "0.4.0"
  :description "Clojure wrapper of JTS, implements the Simple Feature Spec of Open Geospatial Consortium (OGC)."
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [com.vividsolutions/jts "1.13"]
                 [org.geotools/gt-geojson "11.1"]]
  :repositories [["opengeo" "http://repo.opengeo.org/"]]
  :profiles {:dev {:dependencies [[midje "1.6.3"]]
                   :plugins [[lein-midje "3.1.3"]]}}
  :warn-on-reflection true)
