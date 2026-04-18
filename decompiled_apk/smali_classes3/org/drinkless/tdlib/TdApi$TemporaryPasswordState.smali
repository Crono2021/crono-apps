.class public Lorg/drinkless/tdlib/TdApi$TemporaryPasswordState;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TemporaryPasswordState"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3804c7e2


# instance fields
.field public hasPassword:Z

.field public validFor:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33008
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 33009
    return-void
.end method

.method public constructor <init>(ZI)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "i9"    # I

    .line 32998
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32999
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$TemporaryPasswordState;->hasPassword:Z

    .line 33000
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$TemporaryPasswordState;->validFor:I

    .line 33001
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33005
    const v0, 0x3804c7e2

    return v0
.end method
