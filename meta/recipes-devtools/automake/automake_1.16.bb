require automake.inc
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
DEPENDS_class-native = "autoconf-native"

NAMEVER = "${@oe.utils.trim_version("${PV}", 2)}"

RDEPENDS_${PN} += "\
    autoconf \
    perl \
    perl-module-bytes \
    perl-module-data-dumper \
    perl-module-strict \
    perl-module-text-parsewords \
    perl-module-thread-queue \
    perl-module-threads \
    perl-module-vars "

RDEPENDS_${PN}_class-native = "autoconf-native perl-native-runtime"

SRC_URI += " file://python-libdir.patch \
            file://py-compile-compile-only-optimized-byte-code.patch \
            file://buildtest.patch"

SRC_URI[md5sum] = "7fb7155e553dc559ac39cf525f0bb5de"
SRC_URI[sha256sum] = "80da43bb5665596ee389e6d8b64b4f122ea4b92a685b1dbd813cd1f0e0c2d83f"

CACHED_CONFIGUREVARS += "ac_cv_path_PERL=${USRBINPATH}/perl"

do_install_append () {
    install -d ${D}${datadir}
}

BBCLASSEXTEND = "native nativesdk"
