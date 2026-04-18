.class public Lorg/drinkless/tdlib/TdApi$ChatStatisticsInteractionInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatStatisticsInteractionInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x694a9a8d


# instance fields
.field public forwardCount:I

.field public objectType:Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectType;

.field public reactionCount:I

.field public viewCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42870
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42871
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectType;III)V
    .locals 0
    .param p1, "chatStatisticsObjectType"    # Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectType;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "i11"    # I

    .line 42858
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42859
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsInteractionInfo;->objectType:Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectType;

    .line 42860
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsInteractionInfo;->viewCount:I

    .line 42861
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsInteractionInfo;->forwardCount:I

    .line 42862
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsInteractionInfo;->reactionCount:I

    .line 42863
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42867
    const v0, 0x694a9a8d

    return v0
.end method
