.class public Lorg/drinkless/tdlib/TdApi$ChatEventInvitesToggled;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventInvitesToggled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3ba6995


# instance fields
.field public canInviteUsers:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9942
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9943
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 9933
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9934
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventInvitesToggled;->canInviteUsers:Z

    .line 9935
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9939
    const v0, -0x3ba6995

    return v0
.end method
