.class public Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilterBanned;
.super Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SupergroupMembersFilterBanned"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x48289ef3


# instance fields
.field public query:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20652
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;-><init>()V

    .line 20653
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 20643
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;-><init>()V

    .line 20644
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilterBanned;->query:Ljava/lang/String;

    .line 20645
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20649
    const v0, -0x48289ef3

    return v0
.end method
