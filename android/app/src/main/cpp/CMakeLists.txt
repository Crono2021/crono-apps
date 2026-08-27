cmake_minimum_required(VERSION 3.10.2)

project("nodejs_bridge")

# Add libnode.so as a prebuilt shared library
add_library(node SHARED IMPORTED)
set_target_properties(node PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libnode.so)

# Add our bridge code
add_library(native-lib SHARED native-lib.cpp)

# Include node headers
target_include_directories(native-lib PRIVATE ${CMAKE_SOURCE_DIR}/include/node)

# Link log and libnode to our bridge
target_link_libraries(native-lib log node)
