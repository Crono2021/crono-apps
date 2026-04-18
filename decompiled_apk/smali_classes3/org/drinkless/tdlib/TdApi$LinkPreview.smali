.class public Lorg/drinkless/tdlib/TdApi$LinkPreview;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreview"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6714d1f2


# instance fields
.field public author:Ljava/lang/String;

.field public description:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public displayUrl:Ljava/lang/String;

.field public hasLargeMedia:Z

.field public instantViewVersion:I

.field public showAboveText:Z

.field public showLargeMedia:Z

.field public showMediaAboveDescription:Z

.field public siteName:Ljava/lang/String;

.field public skipConfirmation:Z

.field public title:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$LinkPreviewType;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54120
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54121
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$FormattedText;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$LinkPreviewType;ZZZZZI)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;
    .param p5, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p6, "str5"    # Ljava/lang/String;
    .param p7, "linkPreviewType"    # Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
    .param p8, "z8"    # Z
    .param p9, "z9"    # Z
    .param p10, "z10"    # Z
    .param p11, "z11"    # Z
    .param p12, "z12"    # Z
    .param p13, "i9"    # I

    .line 54099
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54100
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->url:Ljava/lang/String;

    .line 54101
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->displayUrl:Ljava/lang/String;

    .line 54102
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->siteName:Ljava/lang/String;

    .line 54103
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->title:Ljava/lang/String;

    .line 54104
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->description:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 54105
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->author:Ljava/lang/String;

    .line 54106
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->type:Lorg/drinkless/tdlib/TdApi$LinkPreviewType;

    .line 54107
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->hasLargeMedia:Z

    .line 54108
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->showLargeMedia:Z

    .line 54109
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->showMediaAboveDescription:Z

    .line 54110
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->skipConfirmation:Z

    .line 54111
    iput-boolean p12, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->showAboveText:Z

    .line 54112
    iput p13, p0, Lorg/drinkless/tdlib/TdApi$LinkPreview;->instantViewVersion:I

    .line 54113
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54117
    const v0, 0x6714d1f2

    return v0
.end method
