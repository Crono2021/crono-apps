.class public Lorg/drinkless/tdlib/TdApi$ChatEventShowMessageSenderToggled;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventShowMessageSenderToggled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2f58b81d


# instance fields
.field public showMessageSender:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10050
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 10051
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 10041
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 10042
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventShowMessageSenderToggled;->showMessageSender:Z

    .line 10043
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10047
    const v0, -0x2f58b81d

    return v0
.end method
