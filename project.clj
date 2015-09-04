(defproject cljts "0.4.4"
  :description "Clojure wrapper of JTS, implements the Simple Feature Spec of Open Geospatial Consortium (OGC)."
  :url "http://github.com/diogok/cljts"
  :license "Distributed under the Eclipse Public License, the same as Clojure."
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.vividsolutions/jts "1.13"]
                 [org.geotools/gt-geojson "13.2"]
                 [org.geotools/gt-geometry "13.2"]
                 [org.geotools/gt-epsg-hsql "13.2"]
                 [org.geotools/gt-referencing "13.2"]]
  :repositories [["osgeo" "http://download.osgeo.org/webdav/geotools/"]]
  :profiles {:dev {:dependencies [[midje "1.7.0"]]
                   :plugins [[lein-midje "3.1.3"]]}}
  :warn-on-reflection true)
