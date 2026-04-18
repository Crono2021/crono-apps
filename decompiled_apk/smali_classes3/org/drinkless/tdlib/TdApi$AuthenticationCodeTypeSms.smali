.class public Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeSms;
.super Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthenticationCodeTypeSms"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3960e288


# instance fields
.field public length:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8862
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 8863
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 8853
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 8854
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeSms;->length:I

    .line 8855
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8859
    const v0, 0x3960e288

    return v0
.end method
