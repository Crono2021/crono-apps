.class public Lorg/drinkless/tdlib/TdApi$ChatEventSignMessagesToggled;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventSignMessagesToggled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4e46d7e2


# instance fields
.field public signMessages:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10068
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 10069
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 10059
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 10060
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventSignMessagesToggled;->signMessages:Z

    .line 10061
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10065
    const v0, -0x4e46d7e2

    return v0
.end method
