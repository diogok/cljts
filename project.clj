(defproject org.clojars.diogok/cljts "0.5.2"
  :description "Clojure wrapper of JTS, implements the Simple Feature Spec of Open Geospatial Consortium (OGC)."
  :url "http://github.com/diogok/cljts"
  :license "Distributed under the Eclipse Public License, the same as Clojure."
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.vividsolutions/jts "1.13"]
                 [org.geotools/gt-geojson "19-RC1"]
                 [org.geotools/gt-geometry "19-RC1"]
                 [org.geotools/gt-shapefile "19-RC1"]
                 [org.geotools/gt-epsg-hsql "19-RC1"]
                 [org.geotools/gt-referencing "19-RC1"]]
  :repositories [["osgeo" "https://download.osgeo.org/webdav/geotools/"]
                 ["clojars" {:sign-releases false}]]
  :profiles {:dev {:dependencies [[midje "1.9.1"]]
                   :plugins [[lein-midje "3.2.1"]]}}
  :warn-on-reflection true)
