.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeChatFolderInvite;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeChatFolderInvite"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x764db6c2


# instance fields
.field public inviteLink:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15288
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15289
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15279
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15280
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeChatFolderInvite;->inviteLink:Ljava/lang/String;

    .line 15281
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15285
    const v0, -0x764db6c2

    return v0
.end method
