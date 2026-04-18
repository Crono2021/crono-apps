.class public Lorg/drinkless/tdlib/TdApi$UserTypeBot;
.super Lorg/drinkless/tdlib/TdApi$UserType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserTypeBot"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6b9c48a6


# instance fields
.field public activeUserCount:I

.field public canBeAddedToAttachmentMenu:Z

.field public canBeEdited:Z

.field public canConnectToBusiness:Z

.field public canJoinGroups:Z

.field public canReadAllGroupMessages:Z

.field public hasMainWebApp:Z

.field public hasTopics:Z

.field public inlineQueryPlaceholder:Ljava/lang/String;

.field public isInline:Z

.field public needLocation:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53868
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserType;-><init>()V

    .line 53869
    return-void
.end method

.method public constructor <init>(ZZZZZZLjava/lang/String;ZZZI)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "z10"    # Z
    .param p4, "z11"    # Z
    .param p5, "z12"    # Z
    .param p6, "z13"    # Z
    .param p7, "str"    # Ljava/lang/String;
    .param p8, "z14"    # Z
    .param p9, "z15"    # Z
    .param p10, "z16"    # Z
    .param p11, "i9"    # I

    .line 53849
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserType;-><init>()V

    .line 53850
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$UserTypeBot;->canBeEdited:Z

    .line 53851
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$UserTypeBot;->canJoinGroups:Z

    .line 53852
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$UserTypeBot;->canReadAllGroupMessages:Z

    .line 53853
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$UserTypeBot;->hasMainWebApp:Z

    .line 53854
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$UserTypeBot;->hasTopics:Z

    .line 53855
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$UserTypeBot;->isInline:Z

    .line 53856
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$UserTypeBot;->inlineQueryPlaceholder:Ljava/lang/String;

    .line 53857
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$UserTypeBot;->needLocation:Z

    .line 53858
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$UserTypeBot;->canConnectToBusiness:Z

    .line 53859
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$UserTypeBot;->canBeAddedToAttachmentMenu:Z

    .line 53860
    iput p11, p0, Lorg/drinkless/tdlib/TdApi$UserTypeBot;->activeUserCount:I

    .line 53861
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53865
    const v0, -0x6b9c48a6

    return v0
.end method
