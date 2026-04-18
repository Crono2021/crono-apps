.class public Lorg/drinkless/tdlib/TdApi$GetSupergroupMembers;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetSupergroupMembers"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatMembers;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2207de38


# instance fields
.field public filter:Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;

.field public limit:I

.field public offset:I

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43638
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43639
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;II)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "supergroupMembersFilter"    # Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;
    .param p4, "i9"    # I
    .param p5, "i10"    # I

    .line 43626
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43627
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetSupergroupMembers;->supergroupId:J

    .line 43628
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetSupergroupMembers;->filter:Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;

    .line 43629
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GetSupergroupMembers;->offset:I

    .line 43630
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetSupergroupMembers;->limit:I

    .line 43631
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43635
    const v0, -0x2207de38

    return v0
.end method
