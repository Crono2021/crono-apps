.class public Lorg/drinkless/tdlib/TdApi$ChatMembers;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatMembers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1da8245e


# instance fields
.field public members:[Lorg/drinkless/tdlib/TdApi$ChatMember;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24284
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24285
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$ChatMember;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "chatMemberArr"    # [Lorg/drinkless/tdlib/TdApi$ChatMember;

    .line 24274
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24275
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatMembers;->totalCount:I

    .line 24276
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatMembers;->members:[Lorg/drinkless/tdlib/TdApi$ChatMember;

    .line 24277
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24281
    const v0, -0x1da8245e

    return v0
.end method
