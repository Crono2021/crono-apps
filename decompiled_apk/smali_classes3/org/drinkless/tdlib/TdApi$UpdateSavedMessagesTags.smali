.class public Lorg/drinkless/tdlib/TdApi$UpdateSavedMessagesTags;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateSavedMessagesTags"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7386424a


# instance fields
.field public savedMessagesTopicId:J

.field public tags:Lorg/drinkless/tdlib/TdApi$SavedMessagesTags;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34848
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34849
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$SavedMessagesTags;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "savedMessagesTags"    # Lorg/drinkless/tdlib/TdApi$SavedMessagesTags;

    .line 34838
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34839
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateSavedMessagesTags;->savedMessagesTopicId:J

    .line 34840
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateSavedMessagesTags;->tags:Lorg/drinkless/tdlib/TdApi$SavedMessagesTags;

    .line 34841
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34845
    const v0, 0x7386424a

    return v0
.end method
