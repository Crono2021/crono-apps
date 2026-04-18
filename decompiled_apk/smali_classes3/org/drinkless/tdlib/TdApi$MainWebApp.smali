.class public Lorg/drinkless/tdlib/TdApi$MainWebApp;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MainWebApp"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x73a7ac7a


# instance fields
.field public mode:Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28184
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28185
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "webAppOpenMode"    # Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;

    .line 28174
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28175
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MainWebApp;->url:Ljava/lang/String;

    .line 28176
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MainWebApp;->mode:Lorg/drinkless/tdlib/TdApi$WebAppOpenMode;

    .line 28177
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28181
    const v0, 0x73a7ac7a

    return v0
.end method
