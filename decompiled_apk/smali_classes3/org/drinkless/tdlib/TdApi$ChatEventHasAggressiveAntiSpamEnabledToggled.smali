.class public Lorg/drinkless/tdlib/TdApi$ChatEventHasAggressiveAntiSpamEnabledToggled;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventHasAggressiveAntiSpamEnabledToggled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x778a8fe


# instance fields
.field public hasAggressiveAntiSpamEnabled:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9870
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9871
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 9861
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9862
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventHasAggressiveAntiSpamEnabledToggled;->hasAggressiveAntiSpamEnabled:Z

    .line 9863
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9867
    const v0, -0x778a8fe

    return v0
.end method
