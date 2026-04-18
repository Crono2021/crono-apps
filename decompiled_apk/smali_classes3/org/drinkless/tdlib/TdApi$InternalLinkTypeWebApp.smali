.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeWebApp;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeWebApp"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7ae9552d


# instance fields
.field public botUsername:Ljava/lang/String;

.field public mode:Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;

.field public startParameter:Ljava/lang/String;

.field public webAppShortName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43998
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 43999
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "webAppOpenMode"    # Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;

    .line 43986
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 43987
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeWebApp;->botUsername:Ljava/lang/String;

    .line 43988
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeWebApp;->webAppShortName:Ljava/lang/String;

    .line 43989
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeWebApp;->startParameter:Ljava/lang/String;

    .line 43990
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeWebApp;->mode:Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;

    .line 43991
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43995
    const v0, 0x7ae9552d

    return v0
.end method
