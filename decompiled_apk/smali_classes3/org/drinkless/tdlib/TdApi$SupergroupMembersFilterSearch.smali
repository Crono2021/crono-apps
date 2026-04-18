.class public Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilterSearch;
.super Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SupergroupMembersFilterSearch"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x651c6045


# instance fields
.field public query:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20706
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;-><init>()V

    .line 20707
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 20697
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilter;-><init>()V

    .line 20698
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SupergroupMembersFilterSearch;->query:Ljava/lang/String;

    .line 20699
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20703
    const v0, -0x651c6045

    return v0
.end method
