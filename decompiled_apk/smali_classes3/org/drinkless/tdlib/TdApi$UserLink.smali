.class public Lorg/drinkless/tdlib/TdApi$UserLink;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1db0fef8


# instance fields
.field public expiresIn:I

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35228
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35229
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 35218
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35219
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UserLink;->url:Ljava/lang/String;

    .line 35220
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UserLink;->expiresIn:I

    .line 35221
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35225
    const v0, 0x1db0fef8

    return v0
.end method
