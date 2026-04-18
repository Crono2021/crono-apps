.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeUserToken;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeUserToken"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x572824a7


# instance fields
.field public token:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15522
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15523
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15513
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15514
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeUserToken;->token:Ljava/lang/String;

    .line 15515
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15519
    const v0, -0x572824a7

    return v0
.end method
