.class public Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeCall;
.super Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthenticationCodeTypeCall"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x61876c67


# instance fields
.field public length:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8826
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 8827
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 8817
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 8818
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeCall;->length:I

    .line 8819
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8823
    const v0, 0x61876c67

    return v0
.end method
