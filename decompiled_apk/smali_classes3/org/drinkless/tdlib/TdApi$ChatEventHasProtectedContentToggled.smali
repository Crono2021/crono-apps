.class public Lorg/drinkless/tdlib/TdApi$ChatEventHasProtectedContentToggled;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventHasProtectedContentToggled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xafbbdff


# instance fields
.field public hasProtectedContent:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9888
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9889
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 9879
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9880
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventHasProtectedContentToggled;->hasProtectedContent:Z

    .line 9881
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9885
    const v0, -0xafbbdff

    return v0
.end method
