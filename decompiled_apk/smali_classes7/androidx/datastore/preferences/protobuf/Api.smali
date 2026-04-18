.class public final Landroidx/datastore/preferences/protobuf/Api;
.super Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;
.source "Api.java"

# interfaces
.implements Landroidx/datastore/preferences/protobuf/ApiOrBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/datastore/preferences/protobuf/Api$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/datastore/preferences/protobuf/GeneratedMessageLite<",
        "Landroidx/datastore/preferences/protobuf/Api;",
        "Landroidx/datastore/preferences/protobuf/Api$Builder;",
        ">;",
        "Landroidx/datastore/preferences/protobuf/ApiOrBuilder;"
    }
.end annotation


# static fields
.field private static final DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

.field public static final METHODS_FIELD_NUMBER:I = 0x2

.field public static final MIXINS_FIELD_NUMBER:I = 0x6

.field public static final NAME_FIELD_NUMBER:I = 0x1

.field public static final OPTIONS_FIELD_NUMBER:I = 0x3

.field private static volatile PARSER:Landroidx/datastore/preferences/protobuf/Parser; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/datastore/preferences/protobuf/Parser<",
            "Landroidx/datastore/preferences/protobuf/Api;",
            ">;"
        }
    .end annotation
.end field

.field public static final SOURCE_CONTEXT_FIELD_NUMBER:I = 0x5

.field public static final SYNTAX_FIELD_NUMBER:I = 0x7

.field public static final VERSION_FIELD_NUMBER:I = 0x4


# instance fields
.field private methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/datastore/preferences/protobuf/Internal$ProtobufList<",
            "Landroidx/datastore/preferences/protobuf/Method;",
            ">;"
        }
    .end annotation
.end field

.field private mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/datastore/preferences/protobuf/Internal$ProtobufList<",
            "Landroidx/datastore/preferences/protobuf/Mixin;",
            ">;"
        }
    .end annotation
.end field

.field private name_:Ljava/lang/String;

.field private options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/datastore/preferences/protobuf/Internal$ProtobufList<",
            "Landroidx/datastore/preferences/protobuf/Option;",
            ">;"
        }
    .end annotation
.end field

.field private sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

.field private syntax_:I

.field private version_:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1932
    new-instance v0, Landroidx/datastore/preferences/protobuf/Api;

    invoke-direct {v0}, Landroidx/datastore/preferences/protobuf/Api;-><init>()V

    .line 1935
    .local v0, "defaultInstance":Landroidx/datastore/preferences/protobuf/Api;
    sput-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    .line 1936
    const-class v1, Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v1, v0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->registerDefaultInstance(Ljava/lang/Class;Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)V

    .line 1938
    .end local v0    # "defaultInstance":Landroidx/datastore/preferences/protobuf/Api;
    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .line 25
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;-><init>()V

    .line 26
    const-string v0, ""

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->name_:Ljava/lang/String;

    .line 27
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Api;->emptyProtobufList()Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v1

    iput-object v1, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 28
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Api;->emptyProtobufList()Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v1

    iput-object v1, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 29
    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->version_:Ljava/lang/String;

    .line 30
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Api;->emptyProtobufList()Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 31
    return-void
.end method

.method static synthetic access$000()Landroidx/datastore/preferences/protobuf/Api;
    .locals 1

    .line 20
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method static synthetic access$100(Landroidx/datastore/preferences/protobuf/Api;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Ljava/lang/String;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->setName(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1000(Landroidx/datastore/preferences/protobuf/Api;Ljava/lang/Iterable;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Ljava/lang/Iterable;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->addAllMethods(Ljava/lang/Iterable;)V

    return-void
.end method

.method static synthetic access$1100(Landroidx/datastore/preferences/protobuf/Api;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;

    .line 20
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->clearMethods()V

    return-void
.end method

.method static synthetic access$1200(Landroidx/datastore/preferences/protobuf/Api;I)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->removeMethods(I)V

    return-void
.end method

.method static synthetic access$1300(Landroidx/datastore/preferences/protobuf/Api;ILandroidx/datastore/preferences/protobuf/Option;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 20
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Api;->setOptions(ILandroidx/datastore/preferences/protobuf/Option;)V

    return-void
.end method

.method static synthetic access$1400(Landroidx/datastore/preferences/protobuf/Api;ILandroidx/datastore/preferences/protobuf/Option$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 20
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Api;->setOptions(ILandroidx/datastore/preferences/protobuf/Option$Builder;)V

    return-void
.end method

.method static synthetic access$1500(Landroidx/datastore/preferences/protobuf/Api;Landroidx/datastore/preferences/protobuf/Option;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->addOptions(Landroidx/datastore/preferences/protobuf/Option;)V

    return-void
.end method

.method static synthetic access$1600(Landroidx/datastore/preferences/protobuf/Api;ILandroidx/datastore/preferences/protobuf/Option;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 20
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Api;->addOptions(ILandroidx/datastore/preferences/protobuf/Option;)V

    return-void
.end method

.method static synthetic access$1700(Landroidx/datastore/preferences/protobuf/Api;Landroidx/datastore/preferences/protobuf/Option$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->addOptions(Landroidx/datastore/preferences/protobuf/Option$Builder;)V

    return-void
.end method

.method static synthetic access$1800(Landroidx/datastore/preferences/protobuf/Api;ILandroidx/datastore/preferences/protobuf/Option$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 20
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Api;->addOptions(ILandroidx/datastore/preferences/protobuf/Option$Builder;)V

    return-void
.end method

.method static synthetic access$1900(Landroidx/datastore/preferences/protobuf/Api;Ljava/lang/Iterable;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Ljava/lang/Iterable;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->addAllOptions(Ljava/lang/Iterable;)V

    return-void
.end method

.method static synthetic access$200(Landroidx/datastore/preferences/protobuf/Api;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;

    .line 20
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->clearName()V

    return-void
.end method

.method static synthetic access$2000(Landroidx/datastore/preferences/protobuf/Api;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;

    .line 20
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->clearOptions()V

    return-void
.end method

.method static synthetic access$2100(Landroidx/datastore/preferences/protobuf/Api;I)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->removeOptions(I)V

    return-void
.end method

.method static synthetic access$2200(Landroidx/datastore/preferences/protobuf/Api;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Ljava/lang/String;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->setVersion(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$2300(Landroidx/datastore/preferences/protobuf/Api;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;

    .line 20
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->clearVersion()V

    return-void
.end method

.method static synthetic access$2400(Landroidx/datastore/preferences/protobuf/Api;Landroidx/datastore/preferences/protobuf/ByteString;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/ByteString;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->setVersionBytes(Landroidx/datastore/preferences/protobuf/ByteString;)V

    return-void
.end method

.method static synthetic access$2500(Landroidx/datastore/preferences/protobuf/Api;Landroidx/datastore/preferences/protobuf/SourceContext;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->setSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext;)V

    return-void
.end method

.method static synthetic access$2600(Landroidx/datastore/preferences/protobuf/Api;Landroidx/datastore/preferences/protobuf/SourceContext$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/SourceContext$Builder;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->setSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext$Builder;)V

    return-void
.end method

.method static synthetic access$2700(Landroidx/datastore/preferences/protobuf/Api;Landroidx/datastore/preferences/protobuf/SourceContext;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->mergeSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext;)V

    return-void
.end method

.method static synthetic access$2800(Landroidx/datastore/preferences/protobuf/Api;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;

    .line 20
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->clearSourceContext()V

    return-void
.end method

.method static synthetic access$2900(Landroidx/datastore/preferences/protobuf/Api;ILandroidx/datastore/preferences/protobuf/Mixin;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Mixin;

    .line 20
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Api;->setMixins(ILandroidx/datastore/preferences/protobuf/Mixin;)V

    return-void
.end method

.method static synthetic access$300(Landroidx/datastore/preferences/protobuf/Api;Landroidx/datastore/preferences/protobuf/ByteString;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/ByteString;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->setNameBytes(Landroidx/datastore/preferences/protobuf/ByteString;)V

    return-void
.end method

.method static synthetic access$3000(Landroidx/datastore/preferences/protobuf/Api;ILandroidx/datastore/preferences/protobuf/Mixin$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Mixin$Builder;

    .line 20
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Api;->setMixins(ILandroidx/datastore/preferences/protobuf/Mixin$Builder;)V

    return-void
.end method

.method static synthetic access$3100(Landroidx/datastore/preferences/protobuf/Api;Landroidx/datastore/preferences/protobuf/Mixin;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/Mixin;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->addMixins(Landroidx/datastore/preferences/protobuf/Mixin;)V

    return-void
.end method

.method static synthetic access$3200(Landroidx/datastore/preferences/protobuf/Api;ILandroidx/datastore/preferences/protobuf/Mixin;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Mixin;

    .line 20
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Api;->addMixins(ILandroidx/datastore/preferences/protobuf/Mixin;)V

    return-void
.end method

.method static synthetic access$3300(Landroidx/datastore/preferences/protobuf/Api;Landroidx/datastore/preferences/protobuf/Mixin$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/Mixin$Builder;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->addMixins(Landroidx/datastore/preferences/protobuf/Mixin$Builder;)V

    return-void
.end method

.method static synthetic access$3400(Landroidx/datastore/preferences/protobuf/Api;ILandroidx/datastore/preferences/protobuf/Mixin$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Mixin$Builder;

    .line 20
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Api;->addMixins(ILandroidx/datastore/preferences/protobuf/Mixin$Builder;)V

    return-void
.end method

.method static synthetic access$3500(Landroidx/datastore/preferences/protobuf/Api;Ljava/lang/Iterable;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Ljava/lang/Iterable;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->addAllMixins(Ljava/lang/Iterable;)V

    return-void
.end method

.method static synthetic access$3600(Landroidx/datastore/preferences/protobuf/Api;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;

    .line 20
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->clearMixins()V

    return-void
.end method

.method static synthetic access$3700(Landroidx/datastore/preferences/protobuf/Api;I)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->removeMixins(I)V

    return-void
.end method

.method static synthetic access$3800(Landroidx/datastore/preferences/protobuf/Api;I)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->setSyntaxValue(I)V

    return-void
.end method

.method static synthetic access$3900(Landroidx/datastore/preferences/protobuf/Api;Landroidx/datastore/preferences/protobuf/Syntax;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/Syntax;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->setSyntax(Landroidx/datastore/preferences/protobuf/Syntax;)V

    return-void
.end method

.method static synthetic access$400(Landroidx/datastore/preferences/protobuf/Api;ILandroidx/datastore/preferences/protobuf/Method;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Method;

    .line 20
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Api;->setMethods(ILandroidx/datastore/preferences/protobuf/Method;)V

    return-void
.end method

.method static synthetic access$4000(Landroidx/datastore/preferences/protobuf/Api;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;

    .line 20
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->clearSyntax()V

    return-void
.end method

.method static synthetic access$500(Landroidx/datastore/preferences/protobuf/Api;ILandroidx/datastore/preferences/protobuf/Method$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Method$Builder;

    .line 20
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Api;->setMethods(ILandroidx/datastore/preferences/protobuf/Method$Builder;)V

    return-void
.end method

.method static synthetic access$600(Landroidx/datastore/preferences/protobuf/Api;Landroidx/datastore/preferences/protobuf/Method;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/Method;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->addMethods(Landroidx/datastore/preferences/protobuf/Method;)V

    return-void
.end method

.method static synthetic access$700(Landroidx/datastore/preferences/protobuf/Api;ILandroidx/datastore/preferences/protobuf/Method;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Method;

    .line 20
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Api;->addMethods(ILandroidx/datastore/preferences/protobuf/Method;)V

    return-void
.end method

.method static synthetic access$800(Landroidx/datastore/preferences/protobuf/Api;Landroidx/datastore/preferences/protobuf/Method$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/Method$Builder;

    .line 20
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->addMethods(Landroidx/datastore/preferences/protobuf/Method$Builder;)V

    return-void
.end method

.method static synthetic access$900(Landroidx/datastore/preferences/protobuf/Api;ILandroidx/datastore/preferences/protobuf/Method$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Api;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Method$Builder;

    .line 20
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Api;->addMethods(ILandroidx/datastore/preferences/protobuf/Method$Builder;)V

    return-void
.end method

.method private addAllMethods(Ljava/lang/Iterable;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable<",
            "+",
            "Landroidx/datastore/preferences/protobuf/Method;",
            ">;)V"
        }
    .end annotation

    .line 262
    .local p1, "values":Ljava/lang/Iterable;, "Ljava/lang/Iterable<+Landroidx/datastore/preferences/protobuf/Method;>;"
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMethodsIsMutable()V

    .line 263
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-static {p1, v0}, Landroidx/datastore/preferences/protobuf/AbstractMessageLite;->addAll(Ljava/lang/Iterable;Ljava/util/List;)V

    .line 265
    return-void
.end method

.method private addAllMixins(Ljava/lang/Iterable;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable<",
            "+",
            "Landroidx/datastore/preferences/protobuf/Mixin;",
            ">;)V"
        }
    .end annotation

    .line 860
    .local p1, "values":Ljava/lang/Iterable;, "Ljava/lang/Iterable<+Landroidx/datastore/preferences/protobuf/Mixin;>;"
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMixinsIsMutable()V

    .line 861
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-static {p1, v0}, Landroidx/datastore/preferences/protobuf/AbstractMessageLite;->addAll(Ljava/lang/Iterable;Ljava/util/List;)V

    .line 863
    return-void
.end method

.method private addAllOptions(Ljava/lang/Iterable;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable<",
            "+",
            "Landroidx/datastore/preferences/protobuf/Option;",
            ">;)V"
        }
    .end annotation

    .line 441
    .local p1, "values":Ljava/lang/Iterable;, "Ljava/lang/Iterable<+Landroidx/datastore/preferences/protobuf/Option;>;"
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureOptionsIsMutable()V

    .line 442
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-static {p1, v0}, Landroidx/datastore/preferences/protobuf/AbstractMessageLite;->addAll(Ljava/lang/Iterable;Ljava/util/List;)V

    .line 444
    return-void
.end method

.method private addMethods(ILandroidx/datastore/preferences/protobuf/Method$Builder;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Method$Builder;

    .line 250
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMethodsIsMutable()V

    .line 251
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p2}, Landroidx/datastore/preferences/protobuf/Method$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(ILjava/lang/Object;)V

    .line 252
    return-void
.end method

.method private addMethods(ILandroidx/datastore/preferences/protobuf/Method;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/Method;

    .line 223
    if-eqz p2, :cond_0

    .line 226
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMethodsIsMutable()V

    .line 227
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(ILjava/lang/Object;)V

    .line 228
    return-void

    .line 224
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private addMethods(Landroidx/datastore/preferences/protobuf/Method$Builder;)V
    .locals 2
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Method$Builder;

    .line 238
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMethodsIsMutable()V

    .line 239
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/Method$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(Ljava/lang/Object;)Z

    .line 240
    return-void
.end method

.method private addMethods(Landroidx/datastore/preferences/protobuf/Method;)V
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/Method;

    .line 208
    if-eqz p1, :cond_0

    .line 211
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMethodsIsMutable()V

    .line 212
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(Ljava/lang/Object;)Z

    .line 213
    return-void

    .line 209
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private addMixins(ILandroidx/datastore/preferences/protobuf/Mixin$Builder;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Mixin$Builder;

    .line 848
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMixinsIsMutable()V

    .line 849
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p2}, Landroidx/datastore/preferences/protobuf/Mixin$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(ILjava/lang/Object;)V

    .line 850
    return-void
.end method

.method private addMixins(ILandroidx/datastore/preferences/protobuf/Mixin;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/Mixin;

    .line 821
    if-eqz p2, :cond_0

    .line 824
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMixinsIsMutable()V

    .line 825
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(ILjava/lang/Object;)V

    .line 826
    return-void

    .line 822
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private addMixins(Landroidx/datastore/preferences/protobuf/Mixin$Builder;)V
    .locals 2
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Mixin$Builder;

    .line 836
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMixinsIsMutable()V

    .line 837
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/Mixin$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(Ljava/lang/Object;)Z

    .line 838
    return-void
.end method

.method private addMixins(Landroidx/datastore/preferences/protobuf/Mixin;)V
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/Mixin;

    .line 806
    if-eqz p1, :cond_0

    .line 809
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMixinsIsMutable()V

    .line 810
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(Ljava/lang/Object;)Z

    .line 811
    return-void

    .line 807
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private addOptions(ILandroidx/datastore/preferences/protobuf/Option$Builder;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 429
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureOptionsIsMutable()V

    .line 430
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p2}, Landroidx/datastore/preferences/protobuf/Option$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(ILjava/lang/Object;)V

    .line 431
    return-void
.end method

.method private addOptions(ILandroidx/datastore/preferences/protobuf/Option;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 402
    if-eqz p2, :cond_0

    .line 405
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureOptionsIsMutable()V

    .line 406
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(ILjava/lang/Object;)V

    .line 407
    return-void

    .line 403
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private addOptions(Landroidx/datastore/preferences/protobuf/Option$Builder;)V
    .locals 2
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 417
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureOptionsIsMutable()V

    .line 418
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/Option$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(Ljava/lang/Object;)Z

    .line 419
    return-void
.end method

.method private addOptions(Landroidx/datastore/preferences/protobuf/Option;)V
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 387
    if-eqz p1, :cond_0

    .line 390
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureOptionsIsMutable()V

    .line 391
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(Ljava/lang/Object;)Z

    .line 392
    return-void

    .line 388
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private clearMethods()V
    .locals 1

    .line 274
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Api;->emptyProtobufList()Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 275
    return-void
.end method

.method private clearMixins()V
    .locals 1

    .line 872
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Api;->emptyProtobufList()Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 873
    return-void
.end method

.method private clearName()V
    .locals 1

    .line 88
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Api;->getDefaultInstance()Landroidx/datastore/preferences/protobuf/Api;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Api;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->name_:Ljava/lang/String;

    .line 89
    return-void
.end method

.method private clearOptions()V
    .locals 1

    .line 453
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Api;->emptyProtobufList()Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 454
    return-void
.end method

.method private clearSourceContext()V
    .locals 1

    .line 703
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 705
    return-void
.end method

.method private clearSyntax()V
    .locals 1

    .line 948
    const/4 v0, 0x0

    iput v0, p0, Landroidx/datastore/preferences/protobuf/Api;->syntax_:I

    .line 949
    return-void
.end method

.method private clearVersion()V
    .locals 1

    .line 583
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Api;->getDefaultInstance()Landroidx/datastore/preferences/protobuf/Api;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Api;->getVersion()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->version_:Ljava/lang/String;

    .line 584
    return-void
.end method

.method private ensureMethodsIsMutable()V
    .locals 1

    .line 167
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->isModifiable()Z

    move-result v0

    if-nez v0, :cond_0

    .line 168
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 169
    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->mutableCopy(Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;)Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 171
    :cond_0
    return-void
.end method

.method private ensureMixinsIsMutable()V
    .locals 1

    .line 765
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->isModifiable()Z

    move-result v0

    if-nez v0, :cond_0

    .line 766
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 767
    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->mutableCopy(Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;)Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 769
    :cond_0
    return-void
.end method

.method private ensureOptionsIsMutable()V
    .locals 1

    .line 346
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->isModifiable()Z

    move-result v0

    if-nez v0, :cond_0

    .line 347
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 348
    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->mutableCopy(Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;)Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 350
    :cond_0
    return-void
.end method

.method public static getDefaultInstance()Landroidx/datastore/preferences/protobuf/Api;
    .locals 1

    .line 1941
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method private mergeSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext;)V
    .locals 2
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 683
    if-eqz p1, :cond_1

    .line 686
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    if-eqz v0, :cond_0

    .line 687
    invoke-static {}, Landroidx/datastore/preferences/protobuf/SourceContext;->getDefaultInstance()Landroidx/datastore/preferences/protobuf/SourceContext;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 688
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 689
    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/SourceContext;->newBuilder(Landroidx/datastore/preferences/protobuf/SourceContext;)Landroidx/datastore/preferences/protobuf/SourceContext$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroidx/datastore/preferences/protobuf/SourceContext$Builder;->mergeFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/SourceContext$Builder;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/SourceContext$Builder;->buildPartial()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/SourceContext;

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    goto :goto_0

    .line 691
    :cond_0
    iput-object p1, p0, Landroidx/datastore/preferences/protobuf/Api;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 694
    :goto_0
    return-void

    .line 684
    :cond_1
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method public static newBuilder()Landroidx/datastore/preferences/protobuf/Api$Builder;
    .locals 1

    .line 1026
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Api;->createBuilder()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api$Builder;

    return-object v0
.end method

.method public static newBuilder(Landroidx/datastore/preferences/protobuf/Api;)Landroidx/datastore/preferences/protobuf/Api$Builder;
    .locals 1
    .param p0, "prototype"    # Landroidx/datastore/preferences/protobuf/Api;

    .line 1029
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-virtual {v0, p0}, Landroidx/datastore/preferences/protobuf/Api;->createBuilder(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api$Builder;

    return-object v0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/Api;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1003
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/Api;->parseDelimitedFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Api;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1009
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/Api;->parseDelimitedFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/Api;
    .locals 1
    .param p0, "data"    # Landroidx/datastore/preferences/protobuf/ByteString;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 967
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/ByteString;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Api;
    .locals 1
    .param p0, "data"    # Landroidx/datastore/preferences/protobuf/ByteString;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 974
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/ByteString;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/CodedInputStream;)Landroidx/datastore/preferences/protobuf/Api;
    .locals 1
    .param p0, "input"    # Landroidx/datastore/preferences/protobuf/CodedInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1014
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/CodedInputStream;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/CodedInputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Api;
    .locals 1
    .param p0, "input"    # Landroidx/datastore/preferences/protobuf/CodedInputStream;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1021
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/CodedInputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/Api;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 991
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method public static parseFrom(Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Api;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 998
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method public static parseFrom(Ljava/nio/ByteBuffer;)Landroidx/datastore/preferences/protobuf/Api;
    .locals 1
    .param p0, "data"    # Ljava/nio/ByteBuffer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 954
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/nio/ByteBuffer;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method public static parseFrom(Ljava/nio/ByteBuffer;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Api;
    .locals 1
    .param p0, "data"    # Ljava/nio/ByteBuffer;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 961
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/nio/ByteBuffer;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method public static parseFrom([B)Landroidx/datastore/preferences/protobuf/Api;
    .locals 1
    .param p0, "data"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 979
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;[B)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method public static parseFrom([BLandroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Api;
    .locals 1
    .param p0, "data"    # [B
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 986
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;[BLandroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Api;

    return-object v0
.end method

.method public static parser()Landroidx/datastore/preferences/protobuf/Parser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/datastore/preferences/protobuf/Parser<",
            "Landroidx/datastore/preferences/protobuf/Api;",
            ">;"
        }
    .end annotation

    .line 1947
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Api;->getParserForType()Landroidx/datastore/preferences/protobuf/Parser;

    move-result-object v0

    return-object v0
.end method

.method private removeMethods(I)V
    .locals 1
    .param p1, "index"    # I

    .line 284
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMethodsIsMutable()V

    .line 285
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->remove(I)Ljava/lang/Object;

    .line 286
    return-void
.end method

.method private removeMixins(I)V
    .locals 1
    .param p1, "index"    # I

    .line 882
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMixinsIsMutable()V

    .line 883
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->remove(I)Ljava/lang/Object;

    .line 884
    return-void
.end method

.method private removeOptions(I)V
    .locals 1
    .param p1, "index"    # I

    .line 463
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureOptionsIsMutable()V

    .line 464
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->remove(I)Ljava/lang/Object;

    .line 465
    return-void
.end method

.method private setMethods(ILandroidx/datastore/preferences/protobuf/Method$Builder;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Method$Builder;

    .line 197
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMethodsIsMutable()V

    .line 198
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p2}, Landroidx/datastore/preferences/protobuf/Method$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 199
    return-void
.end method

.method private setMethods(ILandroidx/datastore/preferences/protobuf/Method;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/Method;

    .line 182
    if-eqz p2, :cond_0

    .line 185
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMethodsIsMutable()V

    .line 186
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 187
    return-void

    .line 183
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setMixins(ILandroidx/datastore/preferences/protobuf/Mixin$Builder;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Mixin$Builder;

    .line 795
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMixinsIsMutable()V

    .line 796
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p2}, Landroidx/datastore/preferences/protobuf/Mixin$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 797
    return-void
.end method

.method private setMixins(ILandroidx/datastore/preferences/protobuf/Mixin;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/Mixin;

    .line 780
    if-eqz p2, :cond_0

    .line 783
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureMixinsIsMutable()V

    .line 784
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 785
    return-void

    .line 781
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setName(Ljava/lang/String;)V
    .locals 1
    .param p1, "value"    # Ljava/lang/String;

    .line 72
    if-eqz p1, :cond_0

    .line 76
    iput-object p1, p0, Landroidx/datastore/preferences/protobuf/Api;->name_:Ljava/lang/String;

    .line 77
    return-void

    .line 73
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setNameBytes(Landroidx/datastore/preferences/protobuf/ByteString;)V
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/ByteString;

    .line 101
    if-eqz p1, :cond_0

    .line 104
    invoke-static {p1}, Landroidx/datastore/preferences/protobuf/Api;->checkByteStringIsUtf8(Landroidx/datastore/preferences/protobuf/ByteString;)V

    .line 106
    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/ByteString;->toStringUtf8()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->name_:Ljava/lang/String;

    .line 107
    return-void

    .line 102
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setOptions(ILandroidx/datastore/preferences/protobuf/Option$Builder;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 376
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureOptionsIsMutable()V

    .line 377
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p2}, Landroidx/datastore/preferences/protobuf/Option$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 378
    return-void
.end method

.method private setOptions(ILandroidx/datastore/preferences/protobuf/Option;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 361
    if-eqz p2, :cond_0

    .line 364
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Api;->ensureOptionsIsMutable()V

    .line 365
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 366
    return-void

    .line 362
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext$Builder;)V
    .locals 1
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/SourceContext$Builder;

    .line 670
    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/SourceContext$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/SourceContext;

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 672
    return-void
.end method

.method private setSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext;)V
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 654
    if-eqz p1, :cond_0

    .line 657
    iput-object p1, p0, Landroidx/datastore/preferences/protobuf/Api;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 659
    return-void

    .line 655
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setSyntax(Landroidx/datastore/preferences/protobuf/Syntax;)V
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/Syntax;

    .line 933
    if-eqz p1, :cond_0

    .line 937
    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/Syntax;->getNumber()I

    move-result v0

    iput v0, p0, Landroidx/datastore/preferences/protobuf/Api;->syntax_:I

    .line 938
    return-void

    .line 934
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setSyntaxValue(I)V
    .locals 0
    .param p1, "value"    # I

    .line 922
    iput p1, p0, Landroidx/datastore/preferences/protobuf/Api;->syntax_:I

    .line 923
    return-void
.end method

.method private setVersion(Ljava/lang/String;)V
    .locals 1
    .param p1, "value"    # Ljava/lang/String;

    .line 552
    if-eqz p1, :cond_0

    .line 556
    iput-object p1, p0, Landroidx/datastore/preferences/protobuf/Api;->version_:Ljava/lang/String;

    .line 557
    return-void

    .line 553
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setVersionBytes(Landroidx/datastore/preferences/protobuf/ByteString;)V
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/ByteString;

    .line 611
    if-eqz p1, :cond_0

    .line 614
    invoke-static {p1}, Landroidx/datastore/preferences/protobuf/Api;->checkByteStringIsUtf8(Landroidx/datastore/preferences/protobuf/ByteString;)V

    .line 616
    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/ByteString;->toStringUtf8()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->version_:Ljava/lang/String;

    .line 617
    return-void

    .line 612
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method


# virtual methods
.method protected final dynamicMethod(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$MethodToInvoke;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 11
    .param p1, "method"    # Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$MethodToInvoke;
    .param p2, "arg0"    # Ljava/lang/Object;
    .param p3, "arg1"    # Ljava/lang/Object;

    .line 1874
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api$1;->$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke:[I

    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$MethodToInvoke;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x0

    packed-switch v0, :pswitch_data_0

    .line 1925
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0

    .line 1922
    :pswitch_0
    return-object v1

    .line 1919
    :pswitch_1
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    return-object v0

    .line 1904
    :pswitch_2
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->PARSER:Landroidx/datastore/preferences/protobuf/Parser;

    .line 1905
    .local v0, "parser":Landroidx/datastore/preferences/protobuf/Parser;, "Landroidx/datastore/preferences/protobuf/Parser<Landroidx/datastore/preferences/protobuf/Api;>;"
    if-nez v0, :cond_1

    .line 1906
    const-class v1, Landroidx/datastore/preferences/protobuf/Api;

    monitor-enter v1

    .line 1907
    :try_start_0
    sget-object v2, Landroidx/datastore/preferences/protobuf/Api;->PARSER:Landroidx/datastore/preferences/protobuf/Parser;

    move-object v0, v2

    .line 1908
    if-nez v0, :cond_0

    .line 1909
    new-instance v2, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;

    sget-object v3, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-direct {v2, v3}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;-><init>(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)V

    move-object v0, v2

    .line 1912
    sput-object v0, Landroidx/datastore/preferences/protobuf/Api;->PARSER:Landroidx/datastore/preferences/protobuf/Parser;

    .line 1914
    :cond_0
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v2

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 1916
    :cond_1
    :goto_0
    return-object v0

    .line 1901
    .end local v0    # "parser":Landroidx/datastore/preferences/protobuf/Parser;, "Landroidx/datastore/preferences/protobuf/Parser<Landroidx/datastore/preferences/protobuf/Api;>;"
    :pswitch_3
    sget-object v0, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    return-object v0

    .line 1882
    :pswitch_4
    const-string/jumbo v1, "name_"

    const-string/jumbo v2, "methods_"

    const-class v3, Landroidx/datastore/preferences/protobuf/Method;

    const-string/jumbo v4, "options_"

    const-class v5, Landroidx/datastore/preferences/protobuf/Option;

    const-string/jumbo v6, "version_"

    const-string/jumbo v7, "sourceContext_"

    const-string/jumbo v8, "mixins_"

    const-class v9, Landroidx/datastore/preferences/protobuf/Mixin;

    const-string/jumbo v10, "syntax_"

    filled-new-array/range {v1 .. v10}, [Ljava/lang/Object;

    move-result-object v0

    .line 1894
    .local v0, "objects":[Ljava/lang/Object;
    const-string v1, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0003\u0000\u0001\u0208\u0002\u001b\u0003\u001b\u0004\u0208\u0005\t\u0006\u001b\u0007\u000c"

    .line 1897
    .local v1, "info":Ljava/lang/String;
    sget-object v2, Landroidx/datastore/preferences/protobuf/Api;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Api;

    invoke-static {v2, v1, v0}, Landroidx/datastore/preferences/protobuf/Api;->newMessageInfo(Landroidx/datastore/preferences/protobuf/MessageLite;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    return-object v2

    .line 1879
    .end local v0    # "objects":[Ljava/lang/Object;
    .end local v1    # "info":Ljava/lang/String;
    :pswitch_5
    new-instance v0, Landroidx/datastore/preferences/protobuf/Api$Builder;

    invoke-direct {v0, v1}, Landroidx/datastore/preferences/protobuf/Api$Builder;-><init>(Landroidx/datastore/preferences/protobuf/Api$1;)V

    return-object v0

    .line 1876
    :pswitch_6
    new-instance v0, Landroidx/datastore/preferences/protobuf/Api;

    invoke-direct {v0}, Landroidx/datastore/preferences/protobuf/Api;-><init>()V

    return-object v0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public getMethods(I)Landroidx/datastore/preferences/protobuf/Method;
    .locals 1
    .param p1, "index"    # I

    .line 153
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Method;

    return-object v0
.end method

.method public getMethodsCount()I
    .locals 1

    .line 142
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->size()I

    move-result v0

    return v0
.end method

.method public getMethodsList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroidx/datastore/preferences/protobuf/Method;",
            ">;"
        }
    .end annotation

    .line 120
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    return-object v0
.end method

.method public getMethodsOrBuilder(I)Landroidx/datastore/preferences/protobuf/MethodOrBuilder;
    .locals 1
    .param p1, "index"    # I

    .line 164
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/MethodOrBuilder;

    return-object v0
.end method

.method public getMethodsOrBuilderList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "+",
            "Landroidx/datastore/preferences/protobuf/MethodOrBuilder;",
            ">;"
        }
    .end annotation

    .line 131
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->methods_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    return-object v0
.end method

.method public getMixins(I)Landroidx/datastore/preferences/protobuf/Mixin;
    .locals 1
    .param p1, "index"    # I

    .line 751
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Mixin;

    return-object v0
.end method

.method public getMixinsCount()I
    .locals 1

    .line 740
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->size()I

    move-result v0

    return v0
.end method

.method public getMixinsList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroidx/datastore/preferences/protobuf/Mixin;",
            ">;"
        }
    .end annotation

    .line 718
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    return-object v0
.end method

.method public getMixinsOrBuilder(I)Landroidx/datastore/preferences/protobuf/MixinOrBuilder;
    .locals 1
    .param p1, "index"    # I

    .line 762
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/MixinOrBuilder;

    return-object v0
.end method

.method public getMixinsOrBuilderList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "+",
            "Landroidx/datastore/preferences/protobuf/MixinOrBuilder;",
            ">;"
        }
    .end annotation

    .line 729
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->mixins_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .line 45
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->name_:Ljava/lang/String;

    return-object v0
.end method

.method public getNameBytes()Landroidx/datastore/preferences/protobuf/ByteString;
    .locals 1

    .line 59
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->name_:Ljava/lang/String;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/ByteString;->copyFromUtf8(Ljava/lang/String;)Landroidx/datastore/preferences/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getOptions(I)Landroidx/datastore/preferences/protobuf/Option;
    .locals 1
    .param p1, "index"    # I

    .line 332
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Option;

    return-object v0
.end method

.method public getOptionsCount()I
    .locals 1

    .line 321
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->size()I

    move-result v0

    return v0
.end method

.method public getOptionsList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroidx/datastore/preferences/protobuf/Option;",
            ">;"
        }
    .end annotation

    .line 299
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    return-object v0
.end method

.method public getOptionsOrBuilder(I)Landroidx/datastore/preferences/protobuf/OptionOrBuilder;
    .locals 1
    .param p1, "index"    # I

    .line 343
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/OptionOrBuilder;

    return-object v0
.end method

.method public getOptionsOrBuilderList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "+",
            "Landroidx/datastore/preferences/protobuf/OptionOrBuilder;",
            ">;"
        }
    .end annotation

    .line 310
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    return-object v0
.end method

.method public getSourceContext()Landroidx/datastore/preferences/protobuf/SourceContext;
    .locals 1

    .line 643
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    if-nez v0, :cond_0

    invoke-static {}, Landroidx/datastore/preferences/protobuf/SourceContext;->getDefaultInstance()Landroidx/datastore/preferences/protobuf/SourceContext;

    move-result-object v0

    :cond_0
    return-object v0
.end method

.method public getSyntax()Landroidx/datastore/preferences/protobuf/Syntax;
    .locals 2

    .line 910
    iget v0, p0, Landroidx/datastore/preferences/protobuf/Api;->syntax_:I

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Syntax;->forNumber(I)Landroidx/datastore/preferences/protobuf/Syntax;

    move-result-object v0

    .line 911
    .local v0, "result":Landroidx/datastore/preferences/protobuf/Syntax;
    if-nez v0, :cond_0

    sget-object v1, Landroidx/datastore/preferences/protobuf/Syntax;->UNRECOGNIZED:Landroidx/datastore/preferences/protobuf/Syntax;

    goto :goto_0

    :cond_0
    move-object v1, v0

    :goto_0
    return-object v1
.end method

.method public getSyntaxValue()I
    .locals 1

    .line 898
    iget v0, p0, Landroidx/datastore/preferences/protobuf/Api;->syntax_:I

    return v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .line 495
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->version_:Ljava/lang/String;

    return-object v0
.end method

.method public getVersionBytes()Landroidx/datastore/preferences/protobuf/ByteString;
    .locals 1

    .line 524
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->version_:Ljava/lang/String;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/ByteString;->copyFromUtf8(Ljava/lang/String;)Landroidx/datastore/preferences/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public hasSourceContext()Z
    .locals 1

    .line 631
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Api;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method
