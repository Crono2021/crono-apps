.class public Lorg/drinkless/tdlib/TdApi$FoundWebApp;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FoundWebApp"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x11572fe2


# instance fields
.field public requestWriteAccess:Z

.field public skipConfirmation:Z

.field public webApp:Lorg/drinkless/tdlib/TdApi$WebApp;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37092
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37093
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$WebApp;ZZ)V
    .locals 0
    .param p1, "webApp"    # Lorg/drinkless/tdlib/TdApi$WebApp;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z

    .line 37081
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37082
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$FoundWebApp;->webApp:Lorg/drinkless/tdlib/TdApi$WebApp;

    .line 37083
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$FoundWebApp;->requestWriteAccess:Z

    .line 37084
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$FoundWebApp;->skipConfirmation:Z

    .line 37085
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37089
    const v0, -0x11572fe2

    return v0
.end method
