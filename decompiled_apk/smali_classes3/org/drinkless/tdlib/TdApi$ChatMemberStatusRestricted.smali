.class public Lorg/drinkless/tdlib/TdApi$ChatMemberStatusRestricted;
.super Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatMemberStatusRestricted"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x630774a6


# instance fields
.field public isMember:Z

.field public permissions:Lorg/drinkless/tdlib/TdApi$ChatPermissions;

.field public restrictedUntilDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36256
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;-><init>()V

    .line 36257
    return-void
.end method

.method public constructor <init>(ZILorg/drinkless/tdlib/TdApi$ChatPermissions;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "i9"    # I
    .param p3, "chatPermissions"    # Lorg/drinkless/tdlib/TdApi$ChatPermissions;

    .line 36245
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;-><init>()V

    .line 36246
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatMemberStatusRestricted;->isMember:Z

    .line 36247
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ChatMemberStatusRestricted;->restrictedUntilDate:I

    .line 36248
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatMemberStatusRestricted;->permissions:Lorg/drinkless/tdlib/TdApi$ChatPermissions;

    .line 36249
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36253
    const v0, 0x630774a6

    return v0
.end method
