.class public Lorg/drinkless/tdlib/TdApi$BasicGroup;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BasicGroup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xb9be971


# instance fields
.field public id:J

.field public isActive:Z

.field public memberCount:I

.field public status:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

.field public upgradedToSupergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46630
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46631
    return-void
.end method

.method public constructor <init>(JILorg/drinkless/tdlib/TdApi$ChatMemberStatus;ZJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "chatMemberStatus"    # Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;
    .param p5, "z8"    # Z
    .param p6, "j9"    # J

    .line 46617
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46618
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$BasicGroup;->id:J

    .line 46619
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$BasicGroup;->memberCount:I

    .line 46620
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$BasicGroup;->status:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 46621
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$BasicGroup;->isActive:Z

    .line 46622
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$BasicGroup;->upgradedToSupergroupId:J

    .line 46623
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46627
    const v0, -0xb9be971

    return v0
.end method
