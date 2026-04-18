.class public Lorg/drinkless/tdlib/TdApi$BusinessConnectedBot;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessConnectedBot"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6c3566ad


# instance fields
.field public botUserId:J

.field public recipients:Lorg/drinkless/tdlib/TdApi$BusinessRecipients;

.field public rights:Lorg/drinkless/tdlib/TdApi$BusinessBotRights;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35860
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35861
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$BusinessRecipients;Lorg/drinkless/tdlib/TdApi$BusinessBotRights;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "businessRecipients"    # Lorg/drinkless/tdlib/TdApi$BusinessRecipients;
    .param p4, "businessBotRights"    # Lorg/drinkless/tdlib/TdApi$BusinessBotRights;

    .line 35849
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35850
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessConnectedBot;->botUserId:J

    .line 35851
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$BusinessConnectedBot;->recipients:Lorg/drinkless/tdlib/TdApi$BusinessRecipients;

    .line 35852
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$BusinessConnectedBot;->rights:Lorg/drinkless/tdlib/TdApi$BusinessBotRights;

    .line 35853
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35857
    const v0, -0x6c3566ad

    return v0
.end method
