.class public Lorg/drinkless/tdlib/TdApi$TMeUrlTypeChatInvite;
.super Lorg/drinkless/tdlib/TdApi$TMeUrlType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TMeUrlTypeChatInvite"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x12b5da49


# instance fields
.field public info:Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20742
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TMeUrlType;-><init>()V

    .line 20743
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;)V
    .locals 0
    .param p1, "chatInviteLinkInfo"    # Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;

    .line 20733
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TMeUrlType;-><init>()V

    .line 20734
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TMeUrlTypeChatInvite;->info:Lorg/drinkless/tdlib/TdApi$ChatInviteLinkInfo;

    .line 20735
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20739
    const v0, 0x12b5da49

    return v0
.end method
