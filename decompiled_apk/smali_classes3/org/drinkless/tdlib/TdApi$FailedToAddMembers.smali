.class public Lorg/drinkless/tdlib/TdApi$FailedToAddMembers;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FailedToAddMembers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x103f5990


# instance fields
.field public failedToAddMembers:[Lorg/drinkless/tdlib/TdApi$FailedToAddMember;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11904
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11905
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$FailedToAddMember;)V
    .locals 0
    .param p1, "failedToAddMemberArr"    # [Lorg/drinkless/tdlib/TdApi$FailedToAddMember;

    .line 11895
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11896
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$FailedToAddMembers;->failedToAddMembers:[Lorg/drinkless/tdlib/TdApi$FailedToAddMember;

    .line 11897
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11901
    const v0, -0x103f5990

    return v0
.end method
