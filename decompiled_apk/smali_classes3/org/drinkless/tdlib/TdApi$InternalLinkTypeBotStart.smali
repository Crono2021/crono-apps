.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBotStart;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeBotStart"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3f985fed


# instance fields
.field public autostart:Z

.field public botUsername:Ljava/lang/String;

.field public startParameter:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38128
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38129
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "z8"    # Z

    .line 38117
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38118
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBotStart;->botUsername:Ljava/lang/String;

    .line 38119
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBotStart;->startParameter:Ljava/lang/String;

    .line 38120
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBotStart;->autostart:Z

    .line 38121
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38125
    const v0, 0x3f985fed

    return v0
.end method
