.class public Lorg/drinkless/tdlib/TdApi$EmailAddressResetStatePending;
.super Lorg/drinkless/tdlib/TdApi$EmailAddressResetState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmailAddressResetStatePending"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x706991d5


# instance fields
.field public resetIn:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11688
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmailAddressResetState;-><init>()V

    .line 11689
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 11679
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmailAddressResetState;-><init>()V

    .line 11680
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$EmailAddressResetStatePending;->resetIn:I

    .line 11681
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11685
    const v0, -0x706991d5

    return v0
.end method
