.class public Lorg/drinkless/tdlib/TdApi$ChatMemberStatusMember;
.super Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatMemberStatusMember"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1f313ea


# instance fields
.field public memberUntilDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10266
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;-><init>()V

    .line 10267
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 10257
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;-><init>()V

    .line 10258
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatMemberStatusMember;->memberUntilDate:I

    .line 10259
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10263
    const v0, -0x1f313ea

    return v0
.end method
